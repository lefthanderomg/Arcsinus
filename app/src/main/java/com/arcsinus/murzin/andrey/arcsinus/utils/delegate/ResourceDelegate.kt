package com.arcsinus.murzin.andrey.arcsinus.utils.delegate

import android.content.res.Resources
import android.support.annotation.ArrayRes
import android.support.annotation.StringRes
import javax.inject.Inject

class ResourceDelegate @Inject constructor(
        private val res: Resources) {

    fun getString(@StringRes id: Int): String = res.getString(id)

    fun getListString(@ArrayRes id: Int): Array<String> = res.getStringArray(id)
}