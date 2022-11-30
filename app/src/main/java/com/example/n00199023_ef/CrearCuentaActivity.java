package com.example.n00199023_ef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.n00199023_ef.adapters.CuentasAdapter;
import com.example.n00199023_ef.entities.Cuenta;
import com.example.n00199023_ef.services.CuentaServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearCuentaActivity extends AppCompatActivity {

    EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        etNombre = findViewById(R.id.etNombre);

    }

    public void guardarCuenta(View view){

        String nombre = etNombre.getText().toString();

        Cuenta cuenta = new Cuenta();
        cuenta.nombre = nombre;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://635789622712d01e140995f4.mockapi.io/")// -> Aquí va la URL sin el Path
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CuentaServices services = retrofit.create(CuentaServices.class);
        services.get().enqueue(new Callback<List<Cuenta>>() {
            @Override
            public void onResponse(Call<List<Cuenta>> call, Response<List<Cuenta>> response) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<List<Cuenta>> call, Throwable t) {

            }
        });
    }
}