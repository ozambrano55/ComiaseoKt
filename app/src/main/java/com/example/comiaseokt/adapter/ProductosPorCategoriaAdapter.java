package com.example.comiaseokt.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comiaseokt.R;
import com.example.comiaseokt.api.ConfigApi;
import com.example.comiaseokt.communication.MostrarBadgeCommunication;
import com.example.comiaseokt.entity.service.DetallePedido;
import com.example.comiaseokt.entity.service.Producto;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class ProductosPorCategoriaAdapter extends RecyclerView.Adapter<ProductosPorCategoriaAdapter.ViewHolder> {
    private List<Producto> listadoProductosPorCategoria;
    private final MostrarBadgeCommunication mostrarBadgeCommunication;

    public ProductosPorCategoriaAdapter(List<Producto> listadoProdcutosPorCategoria, MostrarBadgeCommunication mostrarBadgeCommunication) {
        this.listadoProductosPorCategoria = listadoProdcutosPorCategoria;
        this.mostrarBadgeCommunication = mostrarBadgeCommunication;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_productos_por_categoria, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(this.listadoProductosPorCategoria.get(position));
    }

    @Override
    public int getItemCount() {
        return this.listadoProductosPorCategoria.size();
    }
    public void updateItems(List<Producto> platillosByCategoria){
        this.listadoProductosPorCategoria.clear();
        this.listadoProductosPorCategoria.addAll(platillosByCategoria);
        this.notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgPlatilloC;
        private final TextView namePlatilloC, txtPricePlatilloC;
        private final Button btnOrdenarPC;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgPlatilloC = itemView.findViewById(R.id.imgPlatilloC);
            this.namePlatilloC = itemView.findViewById(R.id.namePlatilloC);
            this.txtPricePlatilloC = itemView.findViewById(R.id.txtPricePlatilloC);
            this.btnOrdenarPC = itemView.findViewById(R.id.btnOrdenarPC);
        }

        public void setItem(final Producto p) {
  /*          String url = ConfigApi.baseUrlE + "/api/documento-almacenado/download/" + p.getFoto().getFileName();*/
            String url ="hola.jpg";
            Picasso picasso = new Picasso.Builder(itemView.getContext())
                    .downloader(new OkHttp3Downloader(ConfigApi.getClient()))
                    .build();
            picasso.load(url)
                    //.networkPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE) //No lo almacena el la caché ni en el disco
                    .error(R.drawable.image_not_found)
                    .into(imgPlatilloC);
            namePlatilloC.setText(p.getNombre());
            txtPricePlatilloC.setText(String.format(Locale.ENGLISH, "S/%.2f", p.getPrecio()));
            btnOrdenarPC.setOnClickListener(v -> {
                DetallePedido detallePedido = new DetallePedido();
                detallePedido.setProducto(p);
                detallePedido.setCantidad(1);
                detallePedido.setPrecio(p.getPrecio());
                mostrarBadgeCommunication.add(detallePedido);
            });
        }
    }
}
