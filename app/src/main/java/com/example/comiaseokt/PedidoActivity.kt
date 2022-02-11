package com.example.comiaseokt
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comiaseokt.adaptadores.ProductoAdapter
import com.example.comiaseokt.api.ApiServicioProducto
import com.example.comiaseokt.databinding.ActivityPedidoBinding
import com.example.comiaseokt.response.ProductoResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PedidoActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private  lateinit var binding: ActivityPedidoBinding
    private  lateinit var adapter: ProductoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svProducto.setOnQueryTextListener(this)
      //  initRecyclerView()
      //  searchByProducto("3800")
        val recyclerView=binding.rvProducto
        val serviceGenerator=ServiceGenerator.builService(ApiServicioProducto::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val calls=serviceGenerator.getProducto("3800")
            val call: Response<ProductoResponse> = getRetrofit().create(ApiServicioProducto::class.java).getProducto("3800")
            val res: ProductoResponse?=call.body()
            runOnUiThread {
                if(call.isSuccessful){
                    //   val images:ArrayList<String> = (res?.img ?: emptyList()) as ArrayList<String>
                    //productoImages.clear()
                    //     productoImages.addAll(images)
                    //adapter.notifyDataSetChanged()
                    //show RecyclerView
                    recyclerView.apply {
                        layoutManager=LinearLayoutManager(this@PedidoActivity)
                        adapter=ProductoAdapter(res?!!)                   }


                }else{
                    //muestra error
                    showError()
                }
            }

        }

    }

    private fun initRecyclerView() {
      //  adapter= ProductoAdapter(productoImages)
       binding.rvProducto.layoutManager=LinearLayoutManager(this)
        binding.rvProducto.adapter=adapter

    }




    private  fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://190.12.55.2:9093/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
   /* private fun searchByProducto(bo: String){
        val recyclerView=findViewById<RecyclerView>(R.id.rvProducto)
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<ProductoResponse> = getRetrofit().create(ApiServicioProducto::class.java).getProducto(bo)
            val res: ProductoResponse?=call.body()
            runOnUiThread {
                if(call.isSuccessful){
                 //   val images:ArrayList<String> = (res?.img ?: emptyList()) as ArrayList<String>
                    //productoImages.clear()
               //     productoImages.addAll(images)
                    //adapter.notifyDataSetChanged()
                    //show RecyclerView
                    recyclerView.apply {
                        layoutManager=LinearLayoutManager(this@PedidoActivity)
                        adapter=ProductoAdapter(res)                   }


                }else{
                    //muestra error
                    showError()
                }
            }

        }
    }
*/
    private fun showError(){
        Toast.makeText(this,"Ha ocurrido un error", Toast.LENGTH_LONG).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query.isNullOrEmpty()){
            if (query != null) {
                //searchByProducto(query)
            }
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return  true
    }
}


