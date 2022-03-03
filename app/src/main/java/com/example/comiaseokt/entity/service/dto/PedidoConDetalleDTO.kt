package com.example.comiaseokt.entity.service.dto

import com.example.comiaseokt.entity.DetallePedido
import com.example.comiaseokt.entity.Pedido

class PedidoConDetallesDTO {
    private var pedido: Pedido
    private var detallePedido: List<DetallePedido>

    constructor() {
        pedido = Pedido()
        detallePedido = ArrayList<DetallePedido>()
    }

    constructor(pedido: Pedido, detallePedido: List<DetallePedido>) {
        this.pedido = pedido
        this.detallePedido = detallePedido
    }

    fun getPedido(): Pedido {
        return pedido
    }

    fun setPedido(pedido: Pedido) {
        this.pedido = pedido
    }

    fun getDetallePedido(): List<DetallePedido> {
        return detallePedido
    }

    fun setDetallePedido(detallePedido: List<DetallePedido>) {
        this.detallePedido = detallePedido
    }
}
