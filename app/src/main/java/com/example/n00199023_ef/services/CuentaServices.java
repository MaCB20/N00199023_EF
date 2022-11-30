package com.example.n00199023_ef.services;

import com.example.n00199023_ef.entities.Cuenta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CuentaServices {
    @GET("cuentas")
    Call<List<Cuenta>> get();

    @POST("cuentas")
    Call<Cuenta> create(@Body Cuenta cuenta);
}
