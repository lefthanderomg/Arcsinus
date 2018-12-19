package com.arcsinus.murzin.andrey.arcsinus.presentation.mapper

import com.arcsinus.murzin.andrey.arcsinus.domain.entity.HeroEntity
import com.arcsinus.murzin.andrey.arcsinus.presentation.model.HeroViewModel
import javax.inject.Inject

class HeroViewMapper @Inject constructor() {

    fun toView(from: HeroEntity): HeroViewModel =
            HeroViewModel(name = from.name,
                    hairColor = from.hairColor,
                    height = from.height,
                    birthYear = from.birthYear,
                    eyeColor = from.eyeColor,
                    gender = from.gender,
                    skinColor = from.skinColor)

}