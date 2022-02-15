package com.example.comiaseokt.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comiaseokt.PostModel
import com.example.comiaseokt.R
import com.example.comiaseokt.databinding.ItemProductoBinding
import com.example.comiaseokt.response.ProductoResponse
import com.squareup.picasso.Picasso

class PostAdapter(val postModel:MutableList<PostModel>):RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_producto,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindView(postModel[position])
    }

    override fun getItemCount(): Int {
       return postModel.size
    }
}
class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    private val binding= ItemProductoBinding.bind(itemView)
    val vref: TextView =binding.txtReferencia
    val vnom: TextView =binding.txtNombre
    val vpre: TextView =binding.txtPrecio
    val vimg: ImageView =binding.ivProducto

    fun bindView(postModel: PostModel){
        vref.text=postModel.Ref
        vnom.text=postModel.Nombre
        vpre.text=postModel.Unit.toString()
        Picasso.get().load(postModel.img).into(vimg)
    }
}