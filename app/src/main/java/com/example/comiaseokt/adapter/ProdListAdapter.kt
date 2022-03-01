package com.example.comiaseokt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.request.ImageRequest
import coil.transform.BlurTransformation
import com.example.comiaseokt.OnClickListeners
import com.example.comiaseokt.PostModel
import com.example.comiaseokt.R
import com.example.comiaseokt.databinding.ItemProductoBinding

class ProdListAdapter (private val listener: OnClickListeners):
    ListAdapter<PostModel, RecyclerView.ViewHolder>(SportDiffCallback()) {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context=parent.context
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_producto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder:RecyclerView.ViewHolder, position: Int) {
        // return holder(postModel [position])
        val sport = getItem(position)
        with(holder as ViewHolder) {
            setListener(sport)

            binding.txtReferencia.text = sport.ref
            binding.txtNombre.text=sport.nombre
            binding.txtPrecio.text=("$"+ String.format( "%.2f", sport.unit ))
            binding.txtCant.text=("Cant. "+ String.format( "%.2f", sport.cant ))

            val request = ImageRequest.Builder(context)
                .data(sport.img)
                .crossfade(true)
                .transformations(
                    listOf(
                        BlurTransformation(context, 25f,0.4F)
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


inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){

       // Picasso.get().load(postModel.img).into(ivImg)
       val binding = ItemProductoBinding.bind(view)

    fun setListener(sport: PostModel){
        binding.root.setOnClickListener { listener.onClick(sport) }
    }
    }
    class SportDiffCallback: DiffUtil.ItemCallback<PostModel>(){
        override fun areItemsTheSame(oldItem: PostModel, newItem: PostModel): Boolean = oldItem.ref== newItem.ref

        override fun areContentsTheSame(oldItem: PostModel, newItem: PostModel): Boolean = oldItem == newItem
    }


}