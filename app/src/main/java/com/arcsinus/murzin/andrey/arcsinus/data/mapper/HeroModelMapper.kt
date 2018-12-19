package com.arcsinus.murzin.andrey.arcsinus.data.mapper

import com.arcsinus.murzin.andrey.arcsinus.data.database.model.HeroModelDb
import com.arcsinus.murzin.andrey.arcsinus.data.model.HeroModel
import com.arcsinus.murzin.andrey.arcsinus.domain.entity.HeroEntity
import javax.inject.Inject

class HeroModelMapper @Inject constructor() {

    fun toEntity(from: HeroModelDb): HeroEntity =
        HeroEntity(name = from.name,
            hairColor = from.hairColor,
            height = from.height,
            birthYear = from.birthYear,
            eyeColor = from.eyeColor,
            gender = from.gender,
            skinColor = from.skinColor)


    fun toDb(from: HeroModel): HeroModelDb =
        HeroModelDb(name = from.name,
            hairColor = from.hairColor,
            height = from.height,
            birthYear = from.birthYear,
            eyeColor = from.eyeColor,
            gender = from.gender,
            skinColor = from.skinColor)
}