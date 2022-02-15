package com.example.comiaseokt
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comiaseokt.UserApplication.Companion.prefs
import com.example.comiaseokt.adaptadores.ProductoAdapter
import com.example.comiaseokt.api.ApiServicioProducto
import com.example.comiaseokt.databinding.ActivityPedidoBinding

import com.example.comiaseokt.response.ProductoResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory



class PedidoActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private  lateinit var binding: ActivityPedidoBinding
    private  lateinit var adapter: ProductoAdapter
    private val ProductoImages= mutableListOf<ProductoResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svProducto.setOnQueryTextListener(this)
        initRecyclerView()


        binding.btnAll.setOnClickListener {
            cargarTodo("3801")
        }
    }
    private fun initRecyclerView() {
        adapter= ProductoAdapter(ProductoImages)
        binding.rvProducto.layoutManager=LinearLayoutManager(this)
        binding.rvProducto.adapter=adapter
    }
    private fun cargarTodo(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ApiServicioProducto::class.java).getProducto("$query")
            val puppies=call.body()
            runOnUiThread {
                if (call.isSuccessful){
                //Show RecyclerView
                    val images=puppies?.img?: emptyList<ProductoResponse>()
                    ProductoImages.clear()
                   // ProductoImages.addAll(images)
                    adapter.notifyDataSetChanged()

                }else  {
                    //
                    showError("Nada")
                }
            }
        }
    }


    private  fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://190.12.55.2:9093/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun showError(ms:String){
        Toast.makeText(this,ms, Toast.LENGTH_LONG).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query.isNullOrEmpty()){
            if (query != null) {
                //CargaTodo(query)
            }
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return  true
    }
}



