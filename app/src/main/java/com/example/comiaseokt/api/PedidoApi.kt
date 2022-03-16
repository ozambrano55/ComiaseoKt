package com.example.comiaseokt.api

import com.example.comiaseokt.activity.GenericResponse
import com.example.comiaseokt.entity.service.Pedido
import com.example.comiaseokt.entity.service.dto.GenerarPedidoDTO
import com.example.comiaseokt.entity.service.dto.PedidoConDetallesDTO
import retrofit2.Call
import retrofit2.http.*

interface PedidoApi {
    @GET(base + "/misPedidos/{idCli}")
    fun listarPedidosPorCliente(@Path("idCli") idCli: Int): Call<GenericResponse<List<PedidoConDetallesDTO?>?>?>?

    @POST(base)
    fun guardarPedido(@Body dto: GenerarPedidoDTO?): Call<GenericResponse<GenerarPedidoDTO?>?>?

    @DELETE(base + "/{id}")
    fun anularPedido(@Path("id") id: Int): Call<GenericResponse<Pedido?>?>?

    companion object {
        const val base = "api/pedido"
    }
}
