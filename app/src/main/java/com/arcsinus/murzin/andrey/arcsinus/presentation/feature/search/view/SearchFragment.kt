package com.arcsinus.murzin.andrey.arcsinus.presentation.feature.search.view


import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arcsinus.murzin.andrey.arcsinus.R
import com.arcsinus.murzin.andrey.arcsinus.presentation.base.BaseFragment
import com.arcsinus.murzin.andrey.arcsinus.presentation.feature.search.adapter.AdapterHero
import com.arcsinus.murzin.andrey.arcsinus.presentation.feature.search.presenter.SearchPresenter
import com.arcsinus.murzin.andrey.arcsinus.presentation.model.HeroViewModel
import com.arcsinus.murzin.andrey.arcsinus.utils.delegate.ToastDelegate
import com.arcsinus.murzin.andrey.arcsinus.utils.ext.setVisible
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.jakewharton.rxbinding2.widget.textChanges
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.progress_bar.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Provider

class SearchFragment : BaseFragment(), SearchView {


    companion object {
        const val TIMEOUT_DEBOUNCE = 800L
    }

    @Inject
    lateinit var provider: Provider<SearchPresenter>

    @InjectPresenter
    lateinit var presenter: SearchPresenter

    @ProvidePresenter
    fun providePresenter(): SearchPresenter = provider.get()

    @LayoutRes
    override fun layoutRes() = R.layout.fragment_search

    @Inject
    lateinit var adapterHero: AdapterHero

    @Inject
    lateinit var toastDelegate: ToastDelegate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapterHero
        recyclerView.layoutManager = LinearLayoutManager(context)

        edSearch.textChanges()
                .skipInitialValue()
                .debounce(TIMEOUT_DEBOUNCE, TimeUnit.MILLISECONDS)
                .map { it.trim() }
                .filter { it.isNotEmpty() }
                .observeOn(schedulers.ui())
                .subscribe({ presenter.searchHero(it.toString()) }, {})
                .also { compositeDisposable.add(it) }
    }

    override fun hideLoad() {
        recyclerView.setVisible(true)
        progressBar.setVisible(false)
    }

    override fun showLoad() {
        recyclerView.setVisible(false)
        progressBar.setVisible(true)
    }

    override fun displayHero(heroList: List<HeroViewModel>) {
        recyclerView.setVisible(true)
        tvEmpty.setVisible(false)
        adapterHero.setData(heroList)
    }

    override fun showMessage(text: String) {
        toastDelegate.showMessage(text)
    }

    override fun showEmptyResult() {
        adapterHero.setData(listOf())
        tvEmpty.setVisible(true)

    }

}
