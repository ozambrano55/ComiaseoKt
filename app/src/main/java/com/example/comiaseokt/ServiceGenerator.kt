package com.example.comiaseokt

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    private val client=OkHttpClient.Builder().build()

    private val retrofit=Retrofit.Builder()
        .baseUrl("http://190.12.55.2:9093/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T>builService(service:Class<T>):T{
        return retrofit.create(service)
    }
}