package com.example.comiaseokt.activity


class GenericResponse<T> {
    var type: String
    var rpta: Int
    var message: String
    var body: T?
        private set

    constructor() {
        type = ""
        rpta = 0
        message = ""
        body = null
    }

    constructor(bodyType: String?, body: Any?) {
        type = ""
        rpta = 0
        message = ""
        this.body = null
    }

    constructor(type: String, rpta: Int, message: String, body: T) {
        this.type = type
        this.rpta = rpta
        this.message = message
        this.body = body
    }

    fun setBody(body: T) {
        this.body = body
    }
}
