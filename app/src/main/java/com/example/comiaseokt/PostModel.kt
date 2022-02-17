package com.example.comiaseokt

import com.google.gson.annotations.SerializedName

data class PostModel (
    @SerializedName("ref")
    var ref: String,
    @SerializedName("nombre")
    var nombre: String,
    @SerializedName("c_Despieze2")
    var cDespieze2: String,
    @SerializedName("n_Despieze2")
    var nDespieze2: String,
    @SerializedName("cant")
    var cant: Float,
    @SerializedName("unit")
    var unit: Float,
    @SerializedName("img")
    var img: String,
    @SerializedName("grupo")
    var grupo: String,
    @SerializedName("d_Ref02")
var dRef02: String
)