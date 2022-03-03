package com.example.comiaseokt.entity

class Producto {


    private var id = 0
    private var nombre: String? = null
   // private var foto: DocumentoAlmacenado? = null
    private var precio: Double? = null
    private var stock = 0
    private var descripcionPlatillo: String? = null
    //private var categoria: Categoria? = null
    private var vigencia = false
    private var recomendado = false

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getNombre(): String? {
        return nombre
    }

    fun setNombre(nombre: String?) {
        this.nombre = nombre
    }

   /* fun getFoto(): DocumentoAlmacenado? {
        return foto
    }

    fun setFoto(foto: DocumentoAlmacenado?) {
        this.foto = foto
    }*/

    fun getPrecio(): Double? {
        return precio
    }

    fun setPrecio(precio: Double?) {
        this.precio = precio
    }

    fun getStock(): Int {
        return stock
    }

    fun setStock(stock: Int) {
        this.stock = stock
    }

    fun getDescripcionPlatillo(): String? {
        return descripcionPlatillo
    }

    fun setDescripcionPlatillo(descripcionPlatillo: String?) {
        this.descripcionPlatillo = descripcionPlatillo
    }

    /*fun getCategoria(): Categoria? {
        return categoria
    }

    fun setCategoria(categoria: Categoria?) {
        this.categoria = categoria
    }*/

    fun isVigencia(): Boolean {
        return vigencia
    }

    fun setVigencia(vigencia: Boolean) {
        this.vigencia = vigencia
    }

    fun isRecomendado(): Boolean {
        return recomendado
    }

    fun setRecomendado(recomendado: Boolean) {
        this.recomendado = recomendado
    }
}