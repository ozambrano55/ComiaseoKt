package com.example.comiaseokt.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.comiaseokt.databinding.ItemProductoBinding
import com.squareup.picasso.Picasso
import java.text.FieldPosition

abstract class BaseViewHolder<T>(itemView: View):RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item:T,position:Int)
}