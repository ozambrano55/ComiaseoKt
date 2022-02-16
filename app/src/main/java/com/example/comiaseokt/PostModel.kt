package com.example.comiaseokt

import com.google.gson.annotations.SerializedName

data class PostModel (
    @SerializedName("c_Despieze2")
    var cDespieze2: String,
    @SerializedName("cant")
    var cant: Double,
    @SerializedName("d_Ref02")
    var dRef02: String,
    @SerializedName("grupo")
    var grupo: String,
    @SerializedName("img")
    var img: String,
    @SerializedName("n_Despieze2")
    var nDespieze2: String,
    @SerializedName("nombre")
    var nombre: String,
    @SerializedName("ref")
    var ref: String,
    @SerializedName("unit")
    var unit: Double
)