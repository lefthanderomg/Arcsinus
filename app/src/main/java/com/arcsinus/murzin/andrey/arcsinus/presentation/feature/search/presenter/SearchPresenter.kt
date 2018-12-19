package com.arcsinus.murzin.andrey.arcsinus.presentation.feature.search.presenter

import com.arcsinus.murzin.andrey.arcsinus.domain.usecase.SearchHeroUseCase
import com.arcsinus.murzin.andrey.arcsinus.presentation.base.BasePresenter
import com.arcsinus.murzin.andrey.arcsinus.presentation.feature.search.view.SearchView
import com.arcsinus.murzin.andrey.arcsinus.presentation.mapper.HeroViewMapper

import com.arellomobile.mvp.InjectViewState

import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class SearchPresenter @Inject constructor(
    private val router: Router,
    private val searchHeroUseCase: SearchHeroUseCase,
    private val viewMapper: HeroViewMapper
) : BasePresenter<SearchView>() {

    fun searchHero(nameHero: String) {
        searchHeroUseCase.execute(SearchHeroUseCase.Param(nameHero))
            .flattenAsObservable { it }
            .map { viewMapper.toView(it) }
            .toList()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .doOnSubscribe { viewState.showLoad() }
            .doFinally { viewState.hideLoad() }
            .subscribe({
                if(it.isNotEmpty()) viewState.displayHero(it)
                else viewState.showEmptyResult()
            },
                { errorHandler.handleError(it) })
            .also { disposables.add(it) }
    }

}
