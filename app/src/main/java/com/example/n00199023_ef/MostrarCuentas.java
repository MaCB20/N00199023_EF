package com.example.n00199023_ef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.n00199023_ef.adapters.CuentasAdapter;
import com.example.n00199023_ef.database.AppDatabase;
import com.example.n00199023_ef.entities.Cuenta;
import com.example.n00199023_ef.services.CuentaServices;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MostrarCuentas extends AppCompatActivity {

    RecyclerView rvCuentas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_cuentas);

        AppDatabase db = AppDatabase.getInstance(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://635789622712d01e140995f4.mockapi.io/")// -> Aquí va la URL sin el Path
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CuentaServices services = retrofit.create(CuentaServices.class);
        services.get().enqueue(new Callback<List<Cuenta>>() {
            @Override
            public void onResponse(Call<List<Cuenta>> call, Response<List<Cuenta>> response) {

                List<Cuenta> data = response.body();

                for(int i = 0;i<data.size();i++){
                    Cuenta cuentaAux = data.get(i);
                    if(cuentaAux != null){
                        db.cuentaDao().update(cuentaAux);
                    }
                    else{
                        db.cuentaDao().create(cuentaAux);
                    }
                }

                List<Cuenta> cuentas = db.cuentaDao().getAll();
                Log.i("MAIN_APP", new Gson().toJson(cuentas));

                rvCuentas = findViewById(R.id.rvCuentas);
                rvCuentas.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvCuentas.setAdapter(new CuentasAdapter(data));
            }

            @Override
            public void onFailure(Call<List<Cuenta>> call, Throwable t) {
                Log.i("MAIN_APP", "Error");
            }
        });
    }
}