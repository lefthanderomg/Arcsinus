package com.arcsinus.murzin.andrey.arcsinus.presentation.feature.main.di

import com.arcsinus.murzin.andrey.arcsinus.di.PerActivity
import com.arcsinus.murzin.andrey.arcsinus.di.PerFragment
import com.arcsinus.murzin.andrey.arcsinus.presentation.feature.main.view.MainActivity
import com.arcsinus.murzin.andrey.arcsinus.presentation.feature.search.di.SearchViewModule
import com.arcsinus.murzin.andrey.arcsinus.presentation.feature.search.view.SearchFragment
import com.arcsinus.murzin.andrey.arcsinus.utils.HttpErrorCodeParser
import com.arcsinus.murzin.andrey.arcsinus.utils.delegate.ResourceDelegate
import com.arcsinus.murzin.andrey.arcsinus.utils.delegate.ToastDelegate
import com.arcsinus.murzin.andrey.arcsinus.utils.ext.weak
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ru.pauri.app.utils.ErrorHandler

@Module
abstract class MainViewModule {


    @Module
    companion object {

        @PerActivity
        @Provides
        @JvmStatic
        fun provideErrorHandler(
            httpErrorCodeParser: HttpErrorCodeParser,
            resourceDelegate: ResourceDelegate
        ): ErrorHandler = ErrorHandler(httpErrorCodeParser, resourceDelegate)

        @PerActivity
        @Provides
        @JvmStatic
        fun provideToastDelegate(activity: MainActivity) = ToastDelegate(activity.weak())


    }

    @PerFragment
    @ContributesAndroidInjector(modules = [SearchViewModule::class])
    abstract fun provideSearchFragmentFactory(): SearchFragment

}
