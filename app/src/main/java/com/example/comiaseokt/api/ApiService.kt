package com.example.comiaseokt.api

import com.example.comiaseokt.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/producto?bo=3800")
    fun getPost():Call<MutableList<PostModel>>
}