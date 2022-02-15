package com.example.comiaseokt.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comiaseokt.R
import com.example.comiaseokt.holder.ProductoViewHolder
import com.example.comiaseokt.response.ProductoResponse

class ProductoAdapter(private val images:List <ProductoResponse>): RecyclerView.Adapter<ProductoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ProductoViewHolder(layoutInflater.inflate(R.layout.item_producto,parent,false))
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val item =images[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int =images.size

}

