package com.arcsinus.murzin.andrey.arcsinus.domain.usecase

import com.arcsinus.murzin.andrey.arcsinus.domain.entity.HeroEntity
import com.arcsinus.murzin.andrey.arcsinus.domain.repository.HeroRepo
import com.arcsinus.murzin.andrey.arcsinus.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class SearchHeroUseCase @Inject constructor(
    private val heroRepo: HeroRepo
) : SingleUseCase<SearchHeroUseCase.Param, List<HeroEntity>>() {


    override fun build(parameters: Param): Single<List<HeroEntity>> =
        heroRepo.searchHero(parameters.nameHero)


    data class Param(val nameHero: String)
}