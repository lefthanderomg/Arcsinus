package com.arcsinus.murzin.andrey.arcsinus.presentation.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arcsinus.murzin.andrey.arcsinus.utils.schedulers.SchedulersProvider
import com.arellomobile.mvp.MvpAppCompatFragment
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseFragment : MvpAppCompatFragment() {

    lateinit var compositeDisposable: CompositeDisposable

    @Inject
    lateinit var schedulers: SchedulersProvider

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        compositeDisposable = CompositeDisposable()
        return inflater.inflate(layoutRes(), container, false)
    }

    @LayoutRes
    protected abstract fun layoutRes(): Int

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

}
