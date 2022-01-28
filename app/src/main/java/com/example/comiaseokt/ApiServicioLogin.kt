package com.example.comiaseokt

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface ApiServicioLogin {
    @GET("api/login")
    suspend fun getLogin(@Query("usu")usr:String,@Query ("pas")pwd:String):Response<LoginResponse>
}