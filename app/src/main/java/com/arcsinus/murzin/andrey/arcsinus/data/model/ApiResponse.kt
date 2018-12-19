package com.arcsinus.murzin.andrey.arcsinus.data.model

import com.google.gson.annotations.SerializedName

class ApiResponse<T>(@SerializedName("results") val results: T)