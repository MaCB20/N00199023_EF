package com.example.n00199023_ef.services;

import com.example.n00199023_ef.entities.Cuenta;
import com.example.n00199023_ef.entities.Movimiento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MovimientoServices {

    @GET("movimientos")
    Call<Movimiento> finById(@Path("movimientoId") int id);

    @GET("movimientos")
    Call<List<Movimiento>> get();

    @POST("movimientos")
    Call<Movimiento> create(@Body Movimiento movimiento);

    @PUT("movimientos/{id}")
    Call<Movimiento> update(@Path("id") int id, @Body Movimiento movimiento);
}
