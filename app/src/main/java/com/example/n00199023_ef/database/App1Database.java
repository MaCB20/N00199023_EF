package com.example.n00199023_ef.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.n00199023_ef.daos.MovimientoDao;
import com.example.n00199023_ef.entities.Movimiento;

@Database(entities = {Movimiento.class}, version = 1)
public abstract class App1Database extends RoomDatabase {

    public abstract MovimientoDao movimientoDao();

    public static App1Database getInstance(Context context){
        return Room.databaseBuilder(context, App1Database.class, "n00199023_ef1")
                .allowMainThreadQueries()
                .build();

    }
}
