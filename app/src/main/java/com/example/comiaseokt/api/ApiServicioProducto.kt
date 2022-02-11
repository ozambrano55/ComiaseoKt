package com.example.comiaseokt.api

import com.example.comiaseokt.response.ProductoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServicioProducto {
    @GET("api/producto")
    suspend fun getProducto(@Query("bo")bo:String): Response<ProductoResponse>
}