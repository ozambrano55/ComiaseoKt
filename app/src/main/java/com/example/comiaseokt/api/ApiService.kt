package com.example.comiaseokt.api

import com.example.comiaseokt.PostModel
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface ApiService  {
    @GET("api/producto")
 suspend  fun getProducto(@Query("bo")bo:String): MutableList<PostModel>
}