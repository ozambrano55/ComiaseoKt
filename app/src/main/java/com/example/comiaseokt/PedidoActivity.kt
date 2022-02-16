package com.example.comiaseokt
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comiaseokt.adapter.PostAdapter
import com.example.comiaseokt.api.ApiService
import com.example.comiaseokt.databinding.ActivityPedidoBinding
import com.example.comiaseokt.retrofit.WeatherEntity
import com.example.comiaseokt.retrofit.WeatherService
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PedidoActivity : AppCompatActivity(), OnClickListener {

    private  lateinit var binding: ActivityPedidoBinding
    private  lateinit var listAdapter:SportListAdapter
    private lateinit var adapter: SportAdapter






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initRecyclerView()



        binding.btnAll.setOnClickListener {
            //setupRecyclerView()
           // setupActionBar()
            //getAllSports()
            //searchByName("3801")
            cargaPostModel()
        }
    }

    private fun cargaPostModel() {

       // CoroutineScope(Dispatchers.IO).launch {
        CoroutineScope(Dispatchers.IO).launch {
            val serviceGenerator = ServiceGenerator.builService(ApiService::class.java)

            val call = serviceGenerator.getProducto("3800")
            runOnUiThread {
                call.enqueue(object : Callback<MutableList<PostModel>> {
                    override fun onResponse(
                        call: Call<MutableList<PostModel>>,
                        response: Response<MutableList<PostModel>>
                    ) {

                        Log.e("Success", response.body().toString())
                        binding.rvProducto.apply {
                            layoutManager = GridLayoutManager(this@PedidoActivity,2)
                            adapter = PostAdapter(response.body()!!)
                        }
                    }

                    override fun onFailure(call: Call<MutableList<PostModel>>, t: Throwable) {
                        t.printStackTrace()
                        Log.e("error", t.message.toString())
                    }
                })
            }

        }
    }


    private fun getAllSports(){
        val sportsData = sports()
        listAdapter.submitList(sportsData)
        /*sportsData.forEach { sport ->
            adapter.add(sport)
        }*/
    }
    private fun sports( ):  MutableList<Sport>{

        val soccerSport = Sport("10100", "ACCESORIOS", "1399","Unico",
            62F,25.52F,"http://190.110.214.14/comi/8066-3.jpg","TECNOLOGIA","")
       return mutableListOf(soccerSport)
    }
    private fun setupRecyclerView() {
        listAdapter = SportListAdapter(this)
        adapter = SportAdapter(this)
        binding.rvProducto.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@PedidoActivity)
            adapter = listAdapter
            //adapter = this@MainActivity.adapter
        }
    }
    private fun setupActionBar(){
        lifecycleScope.launch {
            getWeather()
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
    override fun onClick(sport: Sport) {
        Snackbar.make(binding.root, sport.Ref, Snackbar.LENGTH_SHORT).show()
    }
}




