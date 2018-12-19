package com.arcsinus.murzin.andrey.arcsinus.data.network

import com.arcsinus.murzin.andrey.arcsinus.data.model.ApiResponse
import com.arcsinus.murzin.andrey.arcsinus.data.model.HeroModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AppApi {

    @GET("people/")
    fun searchHero(@Query("search") nameHero: String): Single<ApiResponse<List<HeroModel>>>
}