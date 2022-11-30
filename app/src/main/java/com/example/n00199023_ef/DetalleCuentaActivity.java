package com.example.n00199023_ef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DetalleCuentaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cuenta);
    }

    public void registrarMovimientos(View view){
        Intent intent = new Intent(getApplicationContext(), RegistrarMovimientoActivity.class);
        startActivity(intent);

    }
    public void verMovimientos(View view){
        Intent intent = new Intent(getApplicationContext(), MostrarMovimientoActivity.class);
        startActivity(intent);
    }
    public void sincronizarMovimientos(View view){
        Toast.makeText(getApplicationContext(), "Movimientos Sincronizadas", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}