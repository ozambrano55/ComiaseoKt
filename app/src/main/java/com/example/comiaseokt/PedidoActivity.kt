package com.example.comiaseokt
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comiaseokt.adaptadores.PostAdapter
import com.example.comiaseokt.adaptadores.ProductoAdapter
import com.example.comiaseokt.api.ApiService
import com.example.comiaseokt.api.ApiServicioProducto
import com.example.comiaseokt.api.UserService
import com.example.comiaseokt.databinding.ActivityPedidoBinding

import com.example.comiaseokt.response.ProductoResponse
import com.example.comiaseokt.response.UserDataCollection
import com.example.comiaseokt.response.UserDataCollectionItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory



class PedidoActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private  lateinit var binding: ActivityPedidoBinding
    private  lateinit var adapter: ProductoAdapter
    private val ProductoImages= mutableListOf<ProductoResponse>()
    private val ProdImages= mutableListOf<UserDataCollectionItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svProducto.setOnQueryTextListener(this)
        //initRecyclerView()

        val recyclerView =binding.rvProducto
        val serviceGenerator=ServiceGenerator.builService(ApiService::class.java)
        val call =serviceGenerator.getPost()



//https://www.youtube.com/watch?v=4o6QwVe_2Yg&t=829s


        binding.btnAll.setOnClickListener {
            //cargarTodo("3801")
            //callServiceGetProductos()
            call.enqueue(object :Callback<MutableList<PostModel>>{
                override fun onResponse(
                    call: Call<MutableList<PostModel>>,
                    response: Response<MutableList<PostModel>>
                ) {
                    if(response.isSuccessful){
                        Log.e("Succes", response.body().toString())
                        recyclerView.apply {
                            layoutManager=LinearLayoutManager(this@PedidoActivity)
                            adapter=PostAdapter(response.body()!!)
                        }
                    }
                }

                override fun onFailure(call: Call<MutableList<PostModel>>, t: Throwable) {
                    t.printStackTrace()
                    Log.e("Error",t.message.toString())
                }

            })
        }
    }

    private fun callServiceGetProductos() {
        val ProductService:UserService=RestEngine.getRestEngine().create(UserService::class.java)
        val result:Call<List<UserDataCollectionItem>> =ProductService.ListProducto()

        result.enqueue(object : Callback<List<UserDataCollectionItem>>{
            override fun onResponse(
                call: Call<List<UserDataCollectionItem>>,
                response: Response<List<UserDataCollectionItem>>
            ) {
                showError("ok")
                    binding.rvProducto.apply {
                        layoutManager=LinearLayoutManager(this@PedidoActivity)
                        //adapter=ProductoAdapter(response.body())
                    }

            }

            override fun onFailure(call: Call<List<UserDataCollectionItem>>, t: Throwable) {
                showError("Error")
            }
        })
    }

    private fun initRecyclerView() {
        adapter= ProductoAdapter(ProductoImages)
        binding.rvProducto.layoutManager=LinearLayoutManager(this)
        binding.rvProducto.adapter=adapter
    }
    private fun cargarTodo(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call= getRetrofit().create(ApiServicioProducto::class.java).getProducto("$query")
            val puppies=call.body()
            runOnUiThread {
                if (call.isSuccessful){
                //Show RecyclerView
                    val images=puppies
                    ProductoImages.clear()
                    ProductoImages.addAll(images)
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

private fun <E> MutableList<E>.addAll(elements: List<UserDataCollectionItem>) {

}

private fun <E> List<E>.addAll(elements: UserDataCollection?) {

}



