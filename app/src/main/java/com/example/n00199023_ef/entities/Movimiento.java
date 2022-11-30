package com.example.n00199023_ef.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Movimiento")
public class Movimiento {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "tipo")
    public String tipo;
    @ColumnInfo(name = "monto")
    public String monto;
    @ColumnInfo(name = "motivo")
    public String motivo;
    public double latitud;
    public double longitud;
    @ColumnInfo(name = "url")
    public String url;

}
