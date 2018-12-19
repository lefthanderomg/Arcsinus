package com.arcsinus.murzin.andrey.arcsinus.presentation.feature.main.presenter

import com.arcsinus.murzin.andrey.arcsinus.Screens
import com.arcsinus.murzin.andrey.arcsinus.presentation.feature.main.view.MainView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
    private val router: Router
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        goSearchScreen()
    }

    private fun goSearchScreen() {
        router.newRootScreen(Screens.OnSearchScreen)
    }

}
