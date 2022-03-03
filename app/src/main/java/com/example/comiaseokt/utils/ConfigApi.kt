package com.example.comiaseokt.utils

import com.example.comiaseokt.api.*
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.sql.Date
import java.sql.Time
import java.util.concurrent.TimeUnit

object ConfigApi {
    const val baseUrlE = "http://10.0.2.2:9090"
    const val ipAlexander = "http://192.168.101.8:9090"
    private var retrofit: Retrofit? = null
    private var token = ""
    var usuarioApi: UsuarioApi? = null
        get() {
            if (field == null) {
                field = retrofit!!.create(UsuarioApi::class.java)
            }
            return field
        }
        private set
    var clienteApi: ClienteApi? = null
        get() {
            if (field == null) {
                field = retrofit!!.create(ClienteApi::class.java)
            }
            return field
        }
       /* private set*/
   /* var documentoAlmacenadoApi: DocumentoAlmacenadoApi? = null
        get() {
            if (field == null) {
                field = retrofit!!.create(DocumentoAlmacenadoApi::class.java)
            }
            return field
        }*/
        private set
    var categoriaApi: CategoriaApi? = null
        get() {
            if (field == null) {
                field = retrofit!!.create(CategoriaApi::class.java)
            }
            return field
        }
        private set
    var productoApi: ProductoApi? = null
        get() {
            if (field == null) {
                field= retrofit!!.create(ProductoApi::class.java)
                //field = retrofit!!.create(ProductoApi::class.java)
            }
            return field
        }
        private set
    var pedidoApi: PedidoApi? = null
        get() {
            if (field == null) {
                field = retrofit!!.create(PedidoApi::class.java)
            }
            return field
        }
        private set

    private fun initClient() {
        val gson = GsonBuilder()
            .registerTypeAdapter(Date::class.java, DateSerializer())
            .registerTypeAdapter(Time::class.java, TimeSerializer())
            .create()
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrlE) //Si quieren ejecutar la app desde su móvil, cambiar aquí con la ip de su ordenador
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(getClient())
            .build()
    }

    fun getClient(): OkHttpClient? {
        val loggin = HttpLoggingInterceptor()
        loggin.level = HttpLoggingInterceptor.Level.BODY
        val stetho = StethoInterceptor()
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(loggin)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addNetworkInterceptor(stetho)
        return builder.build()
    }
    fun setToken(value: String) {
        token = value
        initClient()
    }

    init {
        initClient()
    }
}
