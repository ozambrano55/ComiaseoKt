package com.example.comiaseokt
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comiaseokt.adapter.ProAdapter
import com.example.comiaseokt.adapter.ProdListAdapter
import com.example.comiaseokt.api.ApiService
import com.example.comiaseokt.databinding.ActivityPedidoBinding
import com.example.comiaseokt.retrofit.WeatherEntity
import com.example.comiaseokt.retrofit.WeatherService
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PedidoActivity : AppCompatActivity(), OnClickListeners {

    private  lateinit var binding: ActivityPedidoBinding
    private  lateinit var listAdapter:SportListAdapter
    private lateinit var adapter: SportAdapter

    private  lateinit var listAdapters:ProdListAdapter
    private lateinit var adapters: ProAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initRecyclerView()

        setupRecyclerView()

        binding.btnAll.setOnClickListener {
            //setupRecyclerView()
           // setupActionBar()
            //getAllSports()
            //searchByName("3801")
            //cargaPostModel()
            lifecycleScope.launch {
            listAdapters.submitList(getAllProducto())
            }

        }
    }
   /* private fun products(): MutableList<Sport>{
        //return mutableListOf(all)
    }*/

    private suspend fun getAllProducto(): MutableList<PostModel> = withContext(Dispatchers.IO) {
        /*val ProductoData=products()
        listAdapter.submitList(ProductoData)*/

        val retrofit:Retrofit=Retrofit.Builder()
            .baseUrl("http://190.12.55.2:9093/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service:ApiService=retrofit.create(ApiService::class.java)
        service.getProducto("3800")
    }
/*

    private fun getAllSports(){
        val sportsData = sports()
        listAdapters.submitList(sportsData)
        *//*sportsData.forEach { sport ->
            adapter.add(sport)
        }*//*
    }
    private fun sports( ):  MutableList<PostModel>{

        val soccerSport = PostModel("1003", "1003", "1399","Unico",
            24303F,0.06F,"http://190.110.214.14/comi/8066-3.jpg","VARIOS","N/A")
       return mutableListOf(soccerSport)
    }*/
    private fun setupRecyclerView() {
        listAdapters = ProdListAdapter(this)
        adapters = ProAdapter(this)
        binding.rvProducto.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@PedidoActivity,2)
            adapter = listAdapters
            //adapter = this@MainActivity.adapter
        }
    }
    private fun setupActionBar(){
        lifecycleScope.launch {
           // getWeather()
        }
    }
    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://190.12.55.2:9093/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private suspend fun getWeather():WeatherEntity= withContext(Dispatchers.IO) {
        //setupTitle(getString(R.string.main_retrofit_in_progress))
        val retrofit:Retrofit=Retrofit.Builder()
            .baseUrl("http://190.12.55.2:9093/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service:WeatherService=retrofit.create(WeatherService::class.java)

           service.getProducto("3801")

    }




    private fun showError(ms:String){
        Toast.makeText(this,ms, Toast.LENGTH_LONG).show()
    }
    override fun onClick(sport: PostModel) {
        Snackbar.make(binding.root, sport.ref, Snackbar.LENGTH_SHORT).show()
    }
}




