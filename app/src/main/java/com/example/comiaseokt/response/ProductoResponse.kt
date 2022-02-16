package com.example.comiaseokt.response

import com.google.gson.annotations.SerializedName
data class DogResponse(
    val images:List<ProductoResponse>
)
data class ProductoResponse (
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
