package com.arcsinus.murzin.andrey.arcsinus.di.module

import com.arcsinus.murzin.andrey.arcsinus.data.repository.HeroRepoImpl
import com.arcsinus.murzin.andrey.arcsinus.domain.repository.HeroRepo
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {

    @Binds
    fun heroRepo(repoImpl: HeroRepoImpl): HeroRepo
}