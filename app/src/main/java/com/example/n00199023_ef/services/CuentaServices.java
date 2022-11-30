package com.example.n00199023_ef.services;

import com.example.n00199023_ef.entities.Cuenta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CuentaServices {

    @GET("cuentas")
    Call<Cuenta> finById(@Path("cuentaId") int id);

    @GET("cuentas")
    Call<List<Cuenta>> get();

    @POST("cuentas")
    Call<Cuenta> create(@Body Cuenta cuenta);

    @PUT("cuentas/{id}")
    Call<Cuenta> update(@Path("id") int id, @Body Cuenta cuenta);
}
