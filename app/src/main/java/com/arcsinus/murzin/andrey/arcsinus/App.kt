package com.arcsinus.murzin.andrey.arcsinus

import com.arcsinus.murzin.andrey.arcsinus.di.DaggerAppComponent

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().create(this)

}