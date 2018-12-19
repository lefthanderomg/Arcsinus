package com.arcsinus.murzin.andrey.arcsinus.di.module

import com.arcsinus.murzin.andrey.arcsinus.di.PerApplication
import com.arcsinus.murzin.andrey.arcsinus.utils.schedulers.AppSchedulersProvider
import com.arcsinus.murzin.andrey.arcsinus.utils.schedulers.SchedulersProvider
import dagger.Module
import dagger.Provides
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.CompositeDisposable

@Module
class RxModule {

    @PerApplication
    @Provides
    fun provideSchedulers(): SchedulersProvider = AppSchedulersProvider()

    @Provides
    @NonNull
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

}
