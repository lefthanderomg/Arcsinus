package com.arcsinus.murzin.andrey.arcsinus.domain.repository

import com.arcsinus.murzin.andrey.arcsinus.domain.entity.HeroEntity
import io.reactivex.Single

interface HeroRepo {

    fun searchHero(heroName: String): Single<List<HeroEntity>>
}