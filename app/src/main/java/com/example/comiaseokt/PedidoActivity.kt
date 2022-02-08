package com.example.comiaseokt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.comiaseokt.databinding.ActivityLoginBinding
import com.example.comiaseokt.databinding.ActivityPedidoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PedidoActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        binding.btnAll.setOnClickListener {Pedido() }
    }

    private fun Pedido() {
        TODO("Not yet implemented")
    }
    private  fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://190.12.55.2:9092/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun searchByProducto(bo:Int){

        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<ProductoResponse> = getRetrofit().create(ApiServicioProducto::class.java).getProducto(bo)
            val res:ProductoResponse?=call.body()
            runOnUiThread {
                if(call.isSuccessful){
                    //carga variables
                    //val c_funcionario:String=ppupies?.cfuncionario.toString()
                    UserApplication.prefs.saveC_Funcionario(res?.cfuncionario.toString())
                    UserApplication.prefs.saveFuncionario(res?.funcionario.toString())
                    UserApplication.prefs.saveC_Punto_Venta(res?.cpuntoventa.toString())
                    UserApplication.prefs.savePunto(res?.punto.toString())
                    UserApplication.prefs.saveC_BODEGA(res?.cbodega.toString())
                    UserApplication.prefs.saveCod_Pedidos(res?.codpedidos.toString())

                    val puntoventa:String=res?.cpuntoventa.toString()
                    Log.d("C_Funcionairo", UserApplication.prefs.getCFuncionario())
                    Log.d("Funcionairo", UserApplication.prefs.getFuncionario())
                    Log.d("C_Punto_Venta", UserApplication.prefs.getCPuntoVenta())
                    Log.d("Punto", UserApplication.prefs.getPunto())
                    Log.d("C_Bodega", UserApplication.prefs.getCBodega())
                    Log.d("Cod_Pedidos", UserApplication.prefs.getCodPedidos())

                    if(puntoventa.isEmpty()){
                        //goToPuntoActivity()
                    }else {
                        //goToMainActivity()
                    }
                }else{
                    //muestra error
                    showError()
                }
            }

        }
    }

    private fun showError(){
        Toast.makeText(this,"Revisar usuario o contraseña", Toast.LENGTH_LONG).show()
    }
}