package com.example.comiaseokt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comiaseokt.R
import com.example.comiaseokt.entity.DetallePedido
import com.example.comiaseokt.utils.ConfigApi
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import java.util.*

class DetalleMisComprasAdapter(detalles: MutableList<DetallePedido>) :
    RecyclerView.Adapter<DetalleMisComprasAdapter.ViewHolder>() {
    private val detalles: MutableList<DetallePedido>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_detalle_mis_compras, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(detalles[position])
    }

    override fun getItemCount(): Int {
        return detalles.size
    }

    fun updateItems(detalles: List<DetallePedido>?) {
        this.detalles.clear()
        this.detalles.addAll(detalles!!)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val imgProduct: ImageView
        private val txtValueCodDetailPurchases: TextView
        private val txtValuePlatillo: TextView
        private val txtValueQuantity: TextView
        private val txtValuePrecioPlatillo: TextView
        fun setItem(detalle: DetallePedido) {
            val url: String =
                ConfigApi.baseUrlE.toString() + "/api/documento-almacenado/download/" + detalle.getPlatillo()
                   //.getFoto().getFileName()
            val picasso = Picasso.Builder(itemView.context)
                .downloader(OkHttp3Downloader(ConfigApi.getClient()))
                .build()
            picasso.load(url) //.networkPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .error(R.drawable.image_not_found)
                .into(imgProduct)
            txtValueCodDetailPurchases.text =
                "C000" + Integer.toString(detalle.getPedido()!!.getId())
            txtValuePlatillo.setText(detalle.getPlatillo()?.getNombre())
            txtValueQuantity.text = Integer.toString(detalle.getCantidad())
            txtValuePrecioPlatillo.text =
                java.lang.String.format(Locale.ENGLISH, "S/%.2f", detalle.getPrecio())
        }

        init {
            imgProduct = itemView.findViewById(R.id.imgProduct)
            txtValueCodDetailPurchases = itemView.findViewById(R.id.txtValueCodDetailPurchases)
            txtValuePlatillo = itemView.findViewById(R.id.txtValuePlatillo)
            txtValueQuantity = itemView.findViewById(R.id.txtValueQuantity)
            txtValuePrecioPlatillo = itemView.findViewById(R.id.txtValuePrecioPlatillo)
        }
    }

    init {
        this.detalles = detalles
    }
}
