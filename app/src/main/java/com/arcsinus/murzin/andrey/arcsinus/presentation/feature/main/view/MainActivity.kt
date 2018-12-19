package com.arcsinus.murzin.andrey.arcsinus.presentation.feature.main.view

import android.support.annotation.LayoutRes
import com.arcsinus.murzin.andrey.arcsinus.R
import com.arcsinus.murzin.andrey.arcsinus.presentation.base.BaseActivity
import com.arcsinus.murzin.andrey.arcsinus.presentation.feature.main.presenter.MainPresenter
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var provider: Provider<MainPresenter>

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter = provider.get()

    override var navigator: Navigator = object :
            SupportAppNavigator(this, supportFragmentManager, R.id.container) {}

    @LayoutRes
    override fun layoutRes() = R.layout.activity_main

    override fun viewCreated() {
        setSupportActionBar(toolbar)
    }
}
