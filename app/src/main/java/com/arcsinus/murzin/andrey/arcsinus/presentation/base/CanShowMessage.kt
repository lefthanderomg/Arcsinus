package com.arcsinus.murzin.andrey.arcsinus.presentation.base

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType


interface CanShowMessage : MvpView {
    @StateStrategyType(SkipStrategy::class)
    fun showMessage(text: String)
}