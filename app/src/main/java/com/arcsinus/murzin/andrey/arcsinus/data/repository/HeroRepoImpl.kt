package com.arcsinus.murzin.andrey.arcsinus.data.repository

import com.arcsinus.murzin.andrey.arcsinus.data.database.dao.HeroDao
import com.arcsinus.murzin.andrey.arcsinus.data.mapper.HeroModelMapper
import com.arcsinus.murzin.andrey.arcsinus.data.network.AppApi
import com.arcsinus.murzin.andrey.arcsinus.domain.entity.HeroEntity
import com.arcsinus.murzin.andrey.arcsinus.domain.repository.HeroRepo
import io.reactivex.Single
import javax.inject.Inject

class HeroRepoImpl @Inject constructor(
    private val appApi: AppApi,
    private val heroModelMapper: HeroModelMapper,
    private val heroDao: HeroDao
) : HeroRepo {

    override fun searchHero(heroName: String): Single<List<HeroEntity>> =
        appApi.searchHero(heroName)
            .flattenAsObservable { it.results }
            .map { heroModelMapper.toDb(it) }
            .doOnNext { heroDao.insert(it) }
            .map { heroModelMapper.toEntity(it) }
            .toList()
            .onErrorResumeNext{findInLocal(heroName, it)}

    private fun findInLocal(heroName: String, throwable: Throwable): Single<List<HeroEntity>> =
        heroDao.searchHero(heroName)
            .flatMap { if (it.isEmpty()) Single.error(throwable) else Single.just(it) }
            .flattenAsObservable { it }
            .map { heroModelMapper.toEntity(it) }
            .toList()


}