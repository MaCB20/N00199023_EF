package com.example.n00199023_ef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.n00199023_ef.adapters.CuentasAdapter;
import com.example.n00199023_ef.entities.Cuenta;
import com.example.n00199023_ef.services.CuentaServices;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button btnCrearCuenta, btnMostrarCuentas, btnSincronizarCuentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);
        btnMostrarCuentas = findViewById(R.id.btnMostrarCuentas);
        btnSincronizarCuentas = findViewById(R.id.btnSincronizarCuentas);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://635789622712d01e140995f4.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CuentaServices services = retrofit.create(CuentaServices.class);
        /*.get().enqueue(new Callback<List<Cuenta>>(){
            @Override
            public void onResponse(Call<List<Cuenta>> call, Response<List<Cuenta>> response) {

                List<Cuenta> data = response.body();
                rvCuentas = findViewById(R.id.rvCuentas);
                rvCuentas.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvCuentas.setAdapter(new CuentasAdapter(data));
                Log.i("MAIN_APP", "Response: "+response.body().size());
                Log.i("MAIN_APP", new Gson().toJson(data));
            }

            @Override
            public void onFailure(Call<List<Cuenta>> call, Throwable t) {

            }
        });*/
    }

    public void mostrarCuenta(View view){
        Intent intent = new Intent(getApplicationContext(), MostrarCuentas.class);
        startActivity(intent);

    }
    public void crearCuenta(View view){
        Intent intent = new Intent(getApplicationContext(), CrearCuentaActivity.class);
        startActivity(intent);
    }
    public void sincronizarCuentas(View view){
        Toast.makeText(getApplicationContext(), "Cuentas Sincronizadas", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}