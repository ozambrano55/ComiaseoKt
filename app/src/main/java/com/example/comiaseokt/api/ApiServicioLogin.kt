package com.example.comiaseokt.api

import com.example.comiaseokt.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServicioLogin {
    @GET("api/login")
    suspend fun getLogin(@Query("usu")usr:String,@Query ("pas")pwd:String):Response<LoginResponse>
}