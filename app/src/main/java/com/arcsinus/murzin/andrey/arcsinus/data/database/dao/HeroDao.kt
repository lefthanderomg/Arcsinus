package com.arcsinus.murzin.andrey.arcsinus.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.arcsinus.murzin.andrey.arcsinus.data.database.model.HeroModelDb
import io.reactivex.Single

@Dao
interface HeroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: HeroModelDb)

    @Query("SELECT * FROM hero WHERE name LIKE '%' || :heroName  || '%'")
    fun searchHero(heroName: String): Single<List<HeroModelDb>>
}