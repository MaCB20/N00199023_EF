package com.example.n00199023_ef.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.n00199023_ef.daos.CuentaDao;
import com.example.n00199023_ef.entities.Cuenta;

@Database(entities = {Cuenta.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CuentaDao cuentaDao();

    public static AppDatabase getInstance(Context context){
        return Room.databaseBuilder(context, AppDatabase.class, "n00199023_ef")
                .allowMainThreadQueries()
                .build();
    }
}
