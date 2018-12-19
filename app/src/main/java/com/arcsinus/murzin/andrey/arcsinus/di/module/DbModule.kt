package com.arcsinus.murzin.andrey.arcsinus.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.arcsinus.murzin.andrey.arcsinus.data.database.AppDataBase
import com.arcsinus.murzin.andrey.arcsinus.di.PerApplication
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @PerApplication
    @Provides
    fun provideAppDataBase(context: Context): AppDataBase =
        Room.databaseBuilder(context, AppDataBase::class.java, AppDataBase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @PerApplication
    @Provides
    fun provideHeroDao(db: AppDataBase) = db.getHeroDao()
}