package com.example.comiaseokt.api

import com.example.comiaseokt.response.ProductoResponse
import com.example.comiaseokt.response.UserDataCollectionItem
import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("api/producto?bo=3800")
    fun ListProducto():Call<List<UserDataCollectionItem>>
}