package com.example.comiaseokt

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestEngine {

    companion object{

        fun getRestEngine():Retrofit{
            val interceptor= HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client=OkHttpClient.Builder().addInterceptor(interceptor).build()
            val retrofit=Retrofit.Builder()
                .baseUrl("http://190.12.55.2:9093/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit
        }
    }
}