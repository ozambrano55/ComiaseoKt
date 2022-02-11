package com.example.comiaseokt.response

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName ("c_Funcionario")var cfuncionario:String,
    @SerializedName ("funcionario") var funcionario:String,
    @SerializedName ("c_punto_venta") var cpuntoventa:String,
    @SerializedName ("punto") var punto:String,
    @SerializedName ("c_bodega") var cbodega:String,
    @SerializedName ("cod_pedidos") var codpedidos:String
)