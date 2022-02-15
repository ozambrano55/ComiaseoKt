package com.example.comiaseokt.response

import com.google.gson.annotations.SerializedName

class UserDataCollection:ArrayList<UserDataCollectionItem> ()
data class UserDataCollectionItem(
    val Ref:String,
    val Nombre:String,
    val C_Despieze2:String,
    val N_Despieze2:String,
    val cant:Float,
    val Unit:Float,
    val img:String,
    val Grupo:String,
    val D_Ref02:String
)