package com.example.n00199023_ef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.n00199023_ef.adapters.CuentasAdapter;
import com.example.n00199023_ef.database.AppDatabase;
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

        AppDatabase db = AppDatabase.getInstance(this);
        db.cuentaDao().create(cuenta);
        Log.i("MAIN_APP", "Se guardo en BD");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://635789622712d01e140995f4.mockapi.io/")// -> Aquí va la URL sin el Path
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CuentaServices services = retrofit.create(CuentaServices.class);
        services.create(cuenta).enqueue(new Callback<Cuenta>() {
            @Override
            public void onResponse(Call<Cuenta> call, Response<Cuenta> response) {

                Log.i("MAIN_APP", String.valueOf(response.code()));
                Toast.makeText(getApplicationContext(), "Se creo correctamente", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Cuenta> call, Throwable t) {

                Log.i("MAIN_APP", "No se creo");
                Toast.makeText(getApplicationContext(), "No se creo correctamente", Toast.LENGTH_SHORT).show();
            }
        });
    }
}