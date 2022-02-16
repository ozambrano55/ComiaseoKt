package com.example.comiaseokt.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comiaseokt.R
import com.example.comiaseokt.databinding.ItemProductoBinding
import com.example.comiaseokt.response.ProductoResponse
import com.squareup.picasso.Picasso

class ProductoViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding=ItemProductoBinding.bind(view)
    val vref: TextView =binding.txtReferencia
    val vnom: TextView =binding.txtNombre
    val vpre: TextView =binding.txtPrecio
    val vimg: ImageView =binding.ivProducto


     fun bind(image:ProductoResponse){
        //vref.text=image.ref
        //vnom.text=image.nombre
         //vpre.text=image.unit.toString()


         Picasso.get()
             .load(image.img)
             .placeholder(R.drawable.noimg)
             .error(R.drawable.noimg)
             .into(vimg)

    }
}