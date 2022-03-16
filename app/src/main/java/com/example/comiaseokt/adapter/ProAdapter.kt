package com.example.comiaseokt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.request.ImageRequest
import coil.transform.BlurTransformation
import com.example.comiaseokt.OnClickListeners
import com.example.comiaseokt.PostModel
import com.example.comiaseokt.R
import com.example.comiaseokt.databinding.ItemProductoBinding

class ProAdapter (private val listeners: OnClickListeners):
    RecyclerView.Adapter<ProAdapter.ViewHolder>(){

    private lateinit var context: Context
    private val sports = mutableListOf<PostModel>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context=parent.context

        val view=LayoutInflater.from(context).inflate(R.layout.item_productos,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sport = sports[position]
        with(holder) {
            setListener(sport)

            binding.txtReferencia.text=sport.ref
            binding.txtNombre.text=sport.nombre
            binding.txtPrecio.text=("$"+ String.format( "%.2f", sport.unit ))
            binding.txtCant.text=("Cant. "+ String.format( "%.2f", sport.cant ))
            val request = ImageRequest.Builder(context)
                .data(sport.img)
                .crossfade(true)
                .transformations(
                    listOf(
                        BlurTransformation(context, 25f,0.4f)
                    )
                )
                .size(720, 720)
                .target(
                    onStart = {
                        binding.imgPhoto.setImageResource(R.drawable.ic_access_time)
                    },
                    onSuccess = {
                        binding.progressBar.visibility = android.view.View.GONE
                        binding.imgPhoto.scaleType = android.widget.ImageView.ScaleType.CENTER_INSIDE
                        binding.imgPhoto.setImageDrawable(it)
                    },
                    onError = {
                        binding.progressBar.visibility = android.view.View.GONE
                        binding.imgPhoto.setImageResource(R.drawable.ic_error_outline)
                    }
                )
                .build()
            context.imageLoader.enqueue(request)
        }
    }

    override fun getItemCount(): Int =sports.size
    fun add(sport: PostModel) {
        if (!sports.contains(sport)) {
            sports.add(sport)
            notifyItemInserted(sports.size - 1)
        }
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemProductoBinding.bind(view)

        fun setListener(postModel: PostModel){
            binding.root.setOnClickListener { listeners.onClick(postModel) }
        }
    }
}