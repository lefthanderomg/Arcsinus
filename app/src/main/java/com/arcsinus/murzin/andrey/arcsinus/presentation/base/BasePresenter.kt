package com.arcsinus.murzin.andrey.arcsinus.presentation.base

import com.arcsinus.murzin.andrey.arcsinus.utils.schedulers.SchedulersProvider
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import ru.pauri.app.utils.ErrorHandler
import javax.inject.Inject

abstract class BasePresenter<View> : MvpPresenter<View>() where View : MvpView, View : CanShowMessage {

    @Inject
    lateinit var disposables: CompositeDisposable

    @Inject
    lateinit var schedulers: SchedulersProvider

    @Inject
    lateinit var errorHandler: ErrorHandler

    override fun attachView(view: View?) {
        super.attachView(view)
        errorHandler.attachView(viewState)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}