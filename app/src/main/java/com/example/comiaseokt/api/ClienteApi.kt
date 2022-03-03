package com.example.comiaseokt.api

import com.example.comiaseokt.activity.GenericResponse
import com.example.comiaseokt.entity.service.Cliente
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ClienteApi {
    @POST(base)
    fun guardarCliente(@Body c: Cliente?): Call<GenericResponse<Cliente?>?>?

    companion object {
        const val base = "api/cliente"
    }
}
