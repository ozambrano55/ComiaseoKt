package com.example.comiaseokt.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.comiaseokt.databinding.ItemProductoBinding
import com.squareup.picasso.Picasso

class ProductoViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding =ItemProductoBinding.bind(view)

    fun bind(image:String){
        Picasso.get().load(image).into(binding.ivProducto)


    }
}