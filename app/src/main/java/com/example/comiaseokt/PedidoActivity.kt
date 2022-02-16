package com.example.comiaseokt
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comiaseokt.databinding.ActivityPedidoBinding
import com.example.comiaseokt.retrofit.WeatherEntity
import com.example.comiaseokt.retrofit.WeatherService
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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





        binding.btnAll.setOnClickListener {
            setupRecyclerView()
           // setupActionBar()
            getAllSports()
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



