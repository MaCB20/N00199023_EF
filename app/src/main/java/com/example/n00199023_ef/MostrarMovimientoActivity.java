package com.example.n00199023_ef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.n00199023_ef.adapters.CuentasAdapter;
import com.example.n00199023_ef.adapters.MovimientosAdapter;
import com.example.n00199023_ef.database.App1Database;
import com.example.n00199023_ef.entities.Cuenta;
import com.example.n00199023_ef.entities.Movimiento;
import com.example.n00199023_ef.services.CuentaServices;
import com.example.n00199023_ef.services.MovimientoServices;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MostrarMovimientoActivity extends AppCompatActivity {

    RecyclerView rvMovimientos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_movimiento);

        App1Database db = App1Database.getInstance(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://635789622712d01e140995f4.mockapi.io/")// -> Aquí va la URL sin el Path
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovimientoServices services = retrofit.create(MovimientoServices.class);
        services.get().enqueue(new Callback<List<Movimiento>>() {
            @Override
            public void onResponse(Call<List<Movimiento>> call, Response<List<Movimiento>> response) {

                List<Movimiento> data = response.body();

                for(int i = 0;i<data.size();i++){
                    Movimiento moximientoAux = data.get(i);
                    if(moximientoAux != null){
                        db.movimientoDao().update(moximientoAux);
                    }
                    else{
                        db.movimientoDao().create(moximientoAux);
                    }
                }

                List<Movimiento> movimientos = db.movimientoDao().getAll();
                Log.i("MAIN_APP", new Gson().toJson(movimientos));

                rvMovimientos = findViewById(R.id.rvMovimientos);
                rvMovimientos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvMovimientos.setAdapter(new MovimientosAdapter(data));
            }

            @Override
            public void onFailure(Call<List<Movimiento>> call, Throwable t) {
                Log.i("MAIN_APP", "Error");
            }

        });
    }
}