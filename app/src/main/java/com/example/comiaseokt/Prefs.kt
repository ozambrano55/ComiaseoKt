package com.example.comiaseokt

import android.content.Context

class Prefs (context: Context) {
    val SHARED_NAME="Mydtb"
    val SHARED_CFUNCIONARIO="CFuncionario"
    val SHARED_FUNCIONARIO="Funcionario"
    val SHARED_CPUNTOVENTA="C_Punto_Venta"
    val SHARED_PUNTO="Punto"
    val SHARED_CBODEGA="C_Bodega"
    val SHARED_CODPEDIDOS="Cod_Pedidos"

    val storage=context.getSharedPreferences(SHARED_NAME,0)
//INSERTA
    fun saveC_Funcionario (c_funcionario:String){
        storage.edit().putString(SHARED_CFUNCIONARIO, c_funcionario).apply()
    }
    fun saveFuncionario (funcionario:String){
        storage.edit().putString(SHARED_FUNCIONARIO, funcionario).apply()
    }
    fun saveC_Punto_Venta (cpuntoventa:String)     {
        storage.edit().putString(SHARED_CPUNTOVENTA, cpuntoventa).apply()
    }
    fun savePunto (punto:String)     {
        storage.edit().putString(SHARED_PUNTO, punto).apply()
    }
    fun saveC_BODEGA (cbodega:String)     {
        storage.edit().putString(SHARED_CBODEGA, cbodega).apply()
    }
    fun saveCod_Pedidos (codpedidos:String)     {
        storage.edit().putString(SHARED_CODPEDIDOS, codpedidos).apply()
    }
    //RECUPERA
    fun getCFuncionario():String{
        return  storage.getString(SHARED_CFUNCIONARIO,"")!!
    }
    fun getFuncionario():String{
        return storage.getString(SHARED_FUNCIONARIO,"")!!
    }
    fun getCPuntoVenta():String{
        return storage.getString(SHARED_CPUNTOVENTA,"")!!
    }
    fun getPunto():String{
        return  storage.getString(SHARED_PUNTO,"")!!
    }
    fun getCBodega():String{
        return  storage.getString(SHARED_CBODEGA,"")!!
    }
    fun getCodPedidos():String{
        return  storage.getString(SHARED_CODPEDIDOS,"")!!
    }
}