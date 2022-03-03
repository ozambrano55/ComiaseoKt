package com.example.comiaseokt.entity.service.dto

import com.example.comiaseokt.entity.Cliente
import com.example.comiaseokt.entity.DetallePedido
import com.example.comiaseokt.entity.Pedido

class GenerarPedidoDTO {
    private var pedido: Pedido
    private var detallePedidos: ArrayList<DetallePedido>
    private var cliente: Cliente
    fun getPedido(): Pedido {
        return pedido
    }

    fun setPedido(pedido: Pedido) {
        this.pedido = pedido
    }

    fun getCliente(): Cliente {
        return cliente
    }

    fun setCliente(cliente: Cliente) {
        this.cliente = cliente
    }

    fun getDetallePedidos(): ArrayList<DetallePedido> {
        return detallePedidos
    }

    fun setDetallePedidos(detallePedidos: ArrayList<DetallePedido>) {
        this.detallePedidos = detallePedidos
    }

    init {
        pedido = Pedido()
        detallePedidos = ArrayList<DetallePedido>()
        cliente = Cliente()
    }
}
