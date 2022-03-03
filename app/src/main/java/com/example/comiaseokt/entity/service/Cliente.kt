package com.example.comiaseokt.entity.service


class Cliente {
    var id = 0
    var nombres: String? = null
    var apellidoPaterno: String? = null
    var apellidoMaterno: String? = null
    var tipoDoc: String? = null
    var numDoc: String? = null
    var direccionEnvio: String? = null
    var departamento: String? = null
    var provincia: String? = null
    var distrito: String? = null
    var telefono: String? = null
    //var foto: DocumentoAlmacenado? = null

    constructor() {}
    constructor(id: Int) {
        this.id = id
    }

    val nombreCompleto: String
        get() = if (nombres != null && apellidoPaterno != null && apellidoMaterno != null) nombres + " " + apellidoPaterno + " " + apellidoMaterno else "------"
}
