package com.arcsinus.murzin.andrey.arcsinus.di.module

import com.arcsinus.murzin.andrey.arcsinus.di.PerActivity
import com.arcsinus.murzin.andrey.arcsinus.presentation.feature.main.di.MainViewModule
import com.arcsinus.murzin.andrey.arcsinus.presentation.feature.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppBuilderModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainViewModule::class])
    fun provideMainActivityFactory(): MainActivity
}