package com.example.comiaseokt.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("api/producto")
    suspend fun getProducto(@Query("bo")bo:String?): WeatherEntity
}