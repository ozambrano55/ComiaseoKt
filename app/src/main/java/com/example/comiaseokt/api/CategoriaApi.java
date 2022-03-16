package com.example.comiaseokt.api;

import com.example.comiaseokt.entity.GenericResponse;
import com.example.comiaseokt.entity.service.Categoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriaApi {
    String base = "api/categoria";

    @GET(base)
    Call<GenericResponse<List<Categoria>>> listarCategoriasActivas();
}
