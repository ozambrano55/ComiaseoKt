package com.example.comiaseokt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comiaseokt.PostModel
import com.example.comiaseokt.R
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class PostAdapter (val postModel:MutableList<PostModel>):RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_producto,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        return holder.bindView(postModel [position])
    }

    override fun getItemCount(): Int =postModel.size
}
class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    private val tvRef:TextView=itemView.findViewById(R.id.txtReferencia)
    private val tvNombre:TextView=itemView.findViewById(R.id.txtNombre)
    private val tvPrecio:TextView=itemView.findViewById(R.id.txtPrecio)
    private val ivImg:ImageView=itemView.findViewById(R.id.imgPhoto)
    fun bindView(postModel: PostModel){
        tvRef.text=postModel.ref
        tvNombre.text=postModel.nombre
        tvPrecio.text=postModel.unit.toString()
        Picasso.get().load(postModel.img).into(ivImg)
    }
}