package com.example.comiaseokt.response

import com.google.gson.annotations.SerializedName
data class ProductoResponse (
    @SerializedName("Ref")var ref:String,
    @SerializedName("Nombre")var nombre:String,
    @SerializedName("C_Despieze2")var cdespieze2:String,
    @SerializedName("N_Despieze2")var ndespieze2:String,
    @SerializedName("Cant")var cant:Double,
    @SerializedName("Unit")var unit:Double,
    @SerializedName("Img")var img:String,
    @SerializedName("Grupo")var grupo:String,
    @SerializedName("D_Ref02")var dref02:String
)
