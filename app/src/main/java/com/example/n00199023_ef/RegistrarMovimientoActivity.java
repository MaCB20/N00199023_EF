package com.example.n00199023_ef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.n00199023_ef.database.App1Database;
import com.example.n00199023_ef.entities.Cuenta;
import com.example.n00199023_ef.entities.Movimiento;
import com.example.n00199023_ef.services.CuentaServices;
import com.example.n00199023_ef.services.MovimientoServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrarMovimientoActivity extends AppCompatActivity {

    EditText etTipo, etMonto, etMotivo, etURL;
    Button btnObtenerUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_movimiento);

        etTipo = findViewById(R.id.etTipo);
        etMonto = findViewById(R.id.etMonto);
        etMotivo = findViewById(R.id.etMotivo);
        etURL = findViewById(R.id.etURL);

        btnObtenerUbicacion = findViewById(R.id.btnObtenerUbicacion);

    }
    public void guardarMovimiento(View view){

        String tipo = etTipo.getText().toString();
        String monto = etMonto.getText().toString();
        String motivo = etMotivo.getText().toString();
        String url = etURL.getText().toString();


        Movimiento movimiento = new Movimiento();
        movimiento.tipo = tipo;
        movimiento.monto = monto;
        movimiento.motivo = motivo;
        movimiento.url = url;


        App1Database db = App1Database.getInstance(this);
        db.movimientoDao().create(movimiento);
        Log.i("MAIN_APP", "Se guardo en la  BD");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://635789622712d01e140995f4.mockapi.io/")// -> Aquí va la URL sin el Path
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovimientoServices services = retrofit.create(MovimientoServices.class);
        services.create(movimiento).enqueue(new Callback<Movimiento>() {
            @Override
            public void onResponse(Call<Movimiento> call, Response<Movimiento> response) {

                Log.i("MAIN_APP", String.valueOf(response.code()));
                Toast.makeText(getApplicationContext(), "Se creo correctamente", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MostrarCuentas.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Movimiento> call, Throwable t) {

                Log.i("MAIN_APP", "No se creo");
                Toast.makeText(getApplicationContext(), "No se creo correctamente", Toast.LENGTH_SHORT).show();
            }
        });
    }
}