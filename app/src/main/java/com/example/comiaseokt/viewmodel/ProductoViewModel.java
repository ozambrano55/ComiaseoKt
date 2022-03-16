package com.example.comiaseokt.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.comiaseokt.entity.GenericResponse;
import com.example.comiaseokt.entity.service.Producto;
import com.example.comiaseokt.repository.ProductoRepository;

import java.util.List;

public class ProductoViewModel extends AndroidViewModel {
    private final ProductoRepository repository;

    public ProductoViewModel(@NonNull Application application) {
        super(application);
        repository = ProductoRepository.getInstance();
    }
    public LiveData<GenericResponse<List<Producto>>> listarPlatillosRecomendados(){
        return this.repository.listarProductosRecomendados();
    }
    public LiveData<GenericResponse<List<Producto>>> listarPlatillosPorCategoria(int idC){
        return this.repository.listarProductosPorCategoria(idC);
    }
}
