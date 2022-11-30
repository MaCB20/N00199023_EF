package com.example.n00199023_ef.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.n00199023_ef.DetalleCuentaActivity;
import com.example.n00199023_ef.R;
import com.example.n00199023_ef.entities.Cuenta;
import com.google.gson.Gson;

import java.util.List;

public class CuentasAdapter extends RecyclerView.Adapter {

    List<Cuenta> data;

    public CuentasAdapter(List<Cuenta> data){
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View itemView = inflater.inflate(R.layout.item_cuentas, parent, false);

        return new CuentasViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Cuenta cuenta = data.get(position);

        TextView tvNombrecuenta = holder.itemView.findViewById(R.id.tvNombrecuenta);
        tvNombrecuenta.setText(data.get(position).nombre);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetalleCuentaActivity.class);
                intent.putExtra("PELICULA_DATA", new Gson().toJson(cuenta));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class CuentasViewHolder extends RecyclerView.ViewHolder {
        public CuentasViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
