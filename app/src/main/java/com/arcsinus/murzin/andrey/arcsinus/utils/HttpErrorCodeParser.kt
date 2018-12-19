package com.arcsinus.murzin.andrey.arcsinus.utils

import com.arcsinus.murzin.andrey.arcsinus.di.PerApplication
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import javax.inject.Inject

@PerApplication
class HttpErrorCodeParser @Inject constructor(
    private val gson: Gson
) {
    fun parseCode(errorBody: ResponseBody): String? {
        return try {
            val errorString = errorBody.string()
            gson.fromJson(errorString, JsonObject::class.java)
                .asJsonObject.get("error_description")
                .asString
        } catch (e: Exception) {
            null
        }
    }
}