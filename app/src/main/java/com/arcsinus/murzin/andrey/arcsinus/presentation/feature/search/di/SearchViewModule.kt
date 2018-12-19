package com.arcsinus.murzin.andrey.arcsinus.presentation.feature.search.di

import com.arcsinus.murzin.andrey.arcsinus.di.PerFragment
import com.arcsinus.murzin.andrey.arcsinus.presentation.feature.search.adapter.AdapterHero
import com.arcsinus.murzin.andrey.arcsinus.presentation.feature.search.view.SearchFragment
import dagger.Module
import dagger.Provides

@Module
abstract class SearchViewModule {

    @Module
    companion object {

        @Provides
        @PerFragment
        @JvmStatic
        fun provideAdapterHero(fragment: SearchFragment) = AdapterHero()
    }
}
