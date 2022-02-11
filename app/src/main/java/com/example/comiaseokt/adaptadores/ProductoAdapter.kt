package com.example.comiaseokt.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comiaseokt.holder.BaseViewHolder
import com.example.comiaseokt.R
import com.example.comiaseokt.response.ProductoResponse
import com.squareup.picasso.Picasso

class ProductoAdapter(val listaProducto:MutableList <ProductoResponse>): RecyclerView.Adapter<ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        return holder.bindView(listaProducto[position])
    }

    override fun getItemCount(): Int {
        return listaProducto.size
    }
}
class ProductoViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        private val ref:TextView=itemView.findViewById(R.id.txtReferencia)
        private val nombre:TextView=itemView.findViewById(R.id.txtNombre)
        private val precio:TextView=itemView.findViewById(R.id.txtPrecio)
        private val imgv : ImageView =itemView.findViewById(R.id.ivProducto)

        fun bindView(listaProducto: ProductoResponse){
            ref.text=listaProducto.ref
            nombre.text=listaProducto.nombre
            precio.text=listaProducto.cant.toString()
            Picasso.get()
                .load(listaProducto.img)
                .into(imgv)
        }
    }
