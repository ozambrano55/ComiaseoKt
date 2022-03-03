package com.example.comiaseokt.api

import com.example.comiaseokt.activity.GenericResponse
import com.example.comiaseokt.entity.service.Categoria
import retrofit2.Call
import retrofit2.http.GET

interface CategoriaApi {
    @GET(base)
    fun listarCategoriasActivas(): Call<GenericResponse<List<Categoria?>?>?>?

    companion object {
        const val base = "api/categoria"
    }
}
