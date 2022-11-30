package com.example.n00199023_ef.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.n00199023_ef.entities.Cuenta;

import java.util.List;

@Dao
public interface CuentaDao {

    @Query("SELECT * FROM Cuenta")
    List<Cuenta> getAll();

    @Query("SELECT * FROM Cuenta where id = :id")
    Cuenta find(int id);

    @Insert
    void create(Cuenta cuenta);

    @Update
    void update(Cuenta cuenta);

}
