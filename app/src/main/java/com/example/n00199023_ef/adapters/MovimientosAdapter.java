package com.example.n00199023_ef.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.n00199023_ef.DetalleCuentaActivity;
import com.example.n00199023_ef.R;
import com.example.n00199023_ef.entities.Cuenta;
import com.example.n00199023_ef.entities.Movimiento;
import com.google.gson.Gson;

import java.util.List;

public class MovimientosAdapter extends RecyclerView.Adapter{

    List<Movimiento> data;

    public MovimientosAdapter(List<Movimiento> data){
        this.data = data;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View itemView = inflater.inflate(R.layout.item_movimientos, parent, false);

        return new MovimientosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Movimiento movimiento = data.get(position);

        TextView tvTipo = holder.itemView.findViewById(R.id.tvTipo);
        tvTipo.setText(data.get(position).tipo);

        TextView tvMonto = holder.itemView.findViewById(R.id.tvMonto);
        tvMonto.setText(data.get(position).monto);

        TextView tvMotivo = holder.itemView.findViewById(R.id.tvMotivo);
        tvMotivo.setText(data.get(position).motivo);

        TextView tvURL = holder.itemView.findViewById(R.id.tvURL);
        tvURL.setText(data.get(position).url);

        ImageView ivMovimiento = holder.itemView.findViewById(R.id.ivMovimiento);
        ivMovimiento.setImageResource(R.drawable.ic_launcher_foreground);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetalleCuentaActivity.class);
                intent.putExtra("MOVIMIENTO_DATA", new Gson().toJson(movimiento));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class MovimientosViewHolder extends RecyclerView.ViewHolder {
        public MovimientosViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
