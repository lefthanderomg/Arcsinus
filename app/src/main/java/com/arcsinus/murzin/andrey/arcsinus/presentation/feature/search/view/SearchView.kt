package com.arcsinus.murzin.andrey.arcsinus.presentation.feature.search.view

import com.arcsinus.murzin.andrey.arcsinus.presentation.base.CanShowLoad
import com.arcsinus.murzin.andrey.arcsinus.presentation.base.CanShowMessage
import com.arcsinus.murzin.andrey.arcsinus.presentation.model.HeroViewModel
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface SearchView : MvpView, CanShowLoad, CanShowMessage {
    fun displayHero(heroList: List<HeroViewModel>)
    fun showEmptyResult()

}