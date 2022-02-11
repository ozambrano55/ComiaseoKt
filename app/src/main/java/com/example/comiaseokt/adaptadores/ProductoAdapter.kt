package com.example.comiaseokt.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.comiaseokt.holder.ProductoViewHolder
import com.example.comiaseokt.R

class ProductoAdapter ( val images:List<String>): RecyclerView.Adapter<ProductoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return  ProductoViewHolder(layoutInflater.inflate(R.layout.item_producto, parent, false))
    }
    override fun getItemCount(): Int =images.size

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val item:String =images[position]
        holder.bind(item)
    }


}