package com.example.comiaseokt.api

import com.example.comiaseokt.activity.GenericResponse
import com.example.comiaseokt.entity.Producto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ProductoApi {
    @GET(base)
    fun listarPlatillosRecomendados(): Call<GenericResponse<List<Producto?>?>?>?

    @GET(base + "/{idC}")
    fun listarPlatillosPorCategoria(@Path("idC") idC: Int): Call<GenericResponse<List<Producto?>?>?>?

    companion object {
        const val base = "api/platillo"
    }
}
