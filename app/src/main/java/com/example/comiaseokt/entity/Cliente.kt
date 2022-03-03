package com.example.comiaseokt.entity

class Cliente {


    private var id = 0
    private var nombres: String? = null
    private var apellidoPaterno: String? = null
    private var apellidoMaterno: String? = null
    private var tipoDoc: String? = null
    private var numDoc: String? = null
    private var direccionEnvio: String? = null
    private var departamento: String? = null
    private var provincia: String? = null
    private var distrito: String? = null
    private var telefono: String? = null
    //private var foto: DocumentoAlmacenado? = null

    fun Cliente() {}

    fun Cliente(id: Int) {
        this.id = id
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getNombres(): String? {
        return nombres
    }

    fun setNombres(nombres: String?) {
        this.nombres = nombres
    }

    fun getTipoDoc(): String? {
        return tipoDoc
    }

    fun setTipoDoc(tipoDoc: String?) {
        this.tipoDoc = tipoDoc
    }

    fun getNumDoc(): String? {
        return numDoc
    }

    fun setNumDoc(numDoc: String?) {
        this.numDoc = numDoc
    }

    fun getDireccionEnvio(): String? {
        return direccionEnvio
    }

    fun setDireccionEnvio(direccionEnvio: String?) {
        this.direccionEnvio = direccionEnvio
    }

    fun getDepartamento(): String? {
        return departamento
    }

    fun setDepartamento(departamento: String?) {
        this.departamento = departamento
    }

    fun getProvincia(): String? {
        return provincia
    }

    fun setProvincia(provincia: String?) {
        this.provincia = provincia
    }

    fun getDistrito(): String? {
        return distrito
    }

    fun setDistrito(distrito: String?) {
        this.distrito = distrito
    }

    /*fun getFoto(): DocumentoAlmacenado? {
        return foto
    }

    fun setFoto(foto: DocumentoAlmacenado?) {
        this.foto = foto
    }*/

    fun getApellidoPaterno(): String? {
        return apellidoPaterno
    }

    fun setApellidoPaterno(apellidoPaterno: String?) {
        this.apellidoPaterno = apellidoPaterno
    }

    fun getApellidoMaterno(): String? {
        return apellidoMaterno
    }

    fun setApellidoMaterno(apellidoMaterno: String?) {
        this.apellidoMaterno = apellidoMaterno
    }

    fun getTelefono(): String? {
        return telefono
    }

    fun setTelefono(telefono: String?) {
        this.telefono = telefono
    }

    fun getNombreCompleto(): String? {
        return if (nombres != null && apellidoPaterno != null && apellidoMaterno != null) nombres + " " + apellidoPaterno + " " + apellidoMaterno else "------"
    }
}