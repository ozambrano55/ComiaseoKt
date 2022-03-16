package com.example.comiaseokt.activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.comiaseokt.OnClickListeners
import com.example.comiaseokt.PostModel
import com.example.comiaseokt.adapter.ProAdapter
import com.example.comiaseokt.adapter.ProdListAdapter
import com.example.comiaseokt.api.ApiService
import com.example.comiaseokt.databinding.ActivityPedidoBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class InicioActivity :  AppCompatActivity(), OnClickListeners {

    private  lateinit var binding: ActivityPedidoBinding

    private  lateinit var listAdapter:ProdListAdapter
    private lateinit var adapter: ProAdapter
    private lateinit var fibScope: Job

    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.e("FibErro", "$throwable in $coroutineContext")
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
       //setupRecyclerView()

        binding.btnAll.setOnClickListener {
             lifecycleScope.launch {
                 setupRecyclerView()
                 //listAdapters.submitList(getAllProducto())
                 getSportsFlow().collect(){adapter.add(it)}
            }

        }
    }


    private fun getSportsFlow(): Flow<PostModel> = flow {
        getAllProducto().forEach {
            //delay(1_000)
            emit(it)
        }
    }.flowOn(Dispatchers.Default)

    /*override fun onDestroy() {
        if(fibScope.isActive)fibScope.cancel()
        super.onDestroy()
    }*/
    private suspend fun getAllProducto(): MutableList<PostModel> = withContext(Dispatchers.IO) {
                //if (fibScope.isCancelled)throw Exception("Proceso cancelado")
                val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl("http://190.12.55.2:9093/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val service: ApiService = retrofit.create(ApiService::class.java)
                 service.getProducto("3800")
    }

    private fun setupRecyclerView() {

        listAdapter = ProdListAdapter(this)
        adapter = ProAdapter(this)
        binding.rvProducto.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@InicioActivity,2)
            //adapter = listAdapter
            adapter = this@InicioActivity.adapter
        }
    }
    private fun setupActionBar(){
        lifecycleScope.launch {
           // getWeather()
        }
    }
    private fun showError(ms:String){
        Toast.makeText(this,ms, Toast.LENGTH_LONG).show()
    }
    override fun onClick(sport: PostModel) {
        Snackbar.make(binding.root, sport.ref, Snackbar.LENGTH_SHORT).show()
    }
}




