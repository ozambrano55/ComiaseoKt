package com.example.comiaseokt.entity

class DetallePedido {

    private var id = 0
    private var cantidad = 0
    private var precio: Double? = null
    private var producto: Producto? = null
    private var pedido: Pedido? = null

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getCantidad(): Int {
        return cantidad
    }

    fun setCantidad(cantidad: Int) {
        this.cantidad = cantidad
    }

    fun getPrecio(): Double? {
        return precio
    }

    fun setPrecio(precio: Double?) {
        this.precio = precio
    }

    fun getPlatillo(): Producto? {
        return producto
    }

    fun setPlatillo(producto: Producto) {
        this.producto = producto
    }

    fun getPedido(): Pedido? {
        return pedido
    }

    fun setPedido(pedido: Pedido?) {
        this.pedido = pedido
    }

    fun addOne() {
        cantidad++
    }

    fun removeOne() {
        cantidad--
    }

    fun getTotal(): Double {
        return cantidad * precio!!
    }
}