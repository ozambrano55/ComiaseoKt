package com.example.comiaseokt.api

import com.example.comiaseokt.activity.GenericResponse
import com.example.comiaseokt.entity.service.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface UsuarioApi {
    //RUTA DEL CONTROLADOR USUARIO + LA RUTA DEL MÉTODO
    @FormUrlEncoded
    @POST(base + "/login")
    fun login(
        @Field("email") email: String?,
        @Field("pass") contrasenia: String?
    ): Call<GenericResponse<Usuario?>?>?

    @POST(base)
    fun save(@Body u: Usuario?): Call<GenericResponse<Usuario?>?>?

    companion object {
        //RUTA DEL CONTROLADOR USUARIO
        const val base = "api/usuario"
    }
}
