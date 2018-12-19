package com.arcsinus.murzin.andrey.arcsinus.di.module

import android.content.Context

import com.arcsinus.murzin.andrey.arcsinus.App
import com.arcsinus.murzin.andrey.arcsinus.di.PerApplication
import com.arcsinus.murzin.andrey.arcsinus.utils.delegate.ResourceDelegate

import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @PerApplication
    @Provides
    fun provideContext(application: App): Context = application

    @PerApplication
    @Provides
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @PerApplication
    @Provides
    fun provideNavigatorHolder(cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder

    @PerApplication
    @Provides
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router

    @Provides
    @PerApplication
    fun provideResourceDelegate(context: Context) = ResourceDelegate(context.resources)
}
