package com.arcsinus.murzin.andrey.arcsinus.data.database.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "hero")
data class HeroModelDb(
    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String,
    val height: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String
)