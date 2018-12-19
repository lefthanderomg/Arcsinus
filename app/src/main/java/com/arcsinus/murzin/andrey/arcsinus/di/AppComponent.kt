package com.arcsinus.murzin.andrey.arcsinus.di

import com.arcsinus.murzin.andrey.arcsinus.App
import com.arcsinus.murzin.andrey.arcsinus.di.module.*
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [AppModule::class,
        RxModule::class,
        NetworkModule::class,
        AppBuilderModule::class,
        AndroidSupportInjectionModule::class,
        RepoModule::class,
        DbModule::class]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}