package com.arcsinus.murzin.andrey.arcsinus.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.arcsinus.murzin.andrey.arcsinus.data.database.dao.HeroDao
import com.arcsinus.murzin.andrey.arcsinus.data.database.model.HeroModelDb


@Database(
    entities = [HeroModelDb::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    companion object {
        const val DB_NAME = "db_arcsinus"
    }

    abstract fun getHeroDao(): HeroDao

}