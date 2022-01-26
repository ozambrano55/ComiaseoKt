package com.example.comiaseokt

import android.content.Context

class Prefs (val context: Context) {
    val SHARED_NAME="Mydtb"
    val SHARED_C_FUNCIONARIO="C_Funcionario"
    val SHARED_FUNCIONARIO="Funcionario"
    val SHARED_C_PUNTO_VENTA="C_Punto_Venta"
    val SHARED_PUNTO="Punto"
    val SHARED_C_BODEGA="C_Bodega"
    val SHARED_COD_PEDIDOS="Cod_Pedidos"

    val storage=context.getSharedPreferences(SHARED_NAME,0)
//INSERTA
    fun saveC_Funcionario (c_funcionario:String){
        storage.edit().putString(SHARED_C_FUNCIONARIO, c_funcionario).apply()
    }
    fun saveFuncionario (funcionario:String){
        storage.edit().putString(SHARED_FUNCIONARIO, funcionario).apply()
    }
    fun saveC_Punto_Venta (c_punto_venta:String)     {
        storage.edit().putString(SHARED_C_PUNTO_VENTA, c_punto_venta).apply()
    }
    fun savePunto (punto:String)     {
        storage.edit().putString(SHARED_PUNTO, punto).apply()
    }
    fun saveC_BODEGA (c_bodega:String)     {
        storage.edit().putString(SHARED_C_BODEGA, c_bodega).apply()
    }
    fun saveCod_Pedidos (cod_pedidos:String)     {
        storage.edit().putString(SHARED_COD_PEDIDOS, cod_pedidos).apply()
    }
    //RECUPERA
    fun getC_Funcionario():String{
        return  storage.getString(SHARED_C_FUNCIONARIO,"")!!
    }
    fun getFuncionario():String{
        return storage.getString(SHARED_FUNCIONARIO,"")!!
    }
    fun getC_Punto_Venta():String{
        return storage.getString(SHARED_C_PUNTO_VENTA,"")!!
    }
    fun getPunto():String{
        return  storage.getString(SHARED_PUNTO,"")!!
    }
    fun getC_Bodega():String{
        return  storage.getString(SHARED_C_BODEGA,"")!!
    }
    fun getCod_Pedidos():String{
        return  storage.getString(SHARED_COD_PEDIDOS,"")!!
    }
}