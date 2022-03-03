package com.example.comiaseokt.entity

import java.sql.Date

class Pedido {

    private var id = 0
    private var fechaCompra: Date? = null
    private var cliente: Cliente? = null
    private var monto: Double? = null
    private var anularPedido = false

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getFechaCompra(): Date? {
        return fechaCompra
    }

    fun setFechaCompra(fechaCompra: Date?) {
        this.fechaCompra = fechaCompra
    }

    fun getCliente(): Cliente? {
        return cliente
    }

    fun setCliente(cliente: Cliente?) {
        this.cliente = cliente
    }

    fun getMonto(): Double? {
        return monto
    }

    fun setMonto(monto: Double?) {
        this.monto = monto
    }

    fun isAnularPedido(): Boolean {
        return anularPedido
    }

    fun setAnularPedido(anularPedido: Boolean) {
        this.anularPedido = anularPedido
    }
}