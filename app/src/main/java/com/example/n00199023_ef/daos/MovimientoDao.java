package com.example.n00199023_ef.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.n00199023_ef.entities.Cuenta;
import com.example.n00199023_ef.entities.Movimiento;

import java.util.List;
@Dao
public interface MovimientoDao {

    @Query("SELECT * FROM Movimiento")
    List<Movimiento> getAll();

    @Query("SELECT * FROM Movimiento where id = :id")
    Movimiento find(int id);

    @Insert
    void create(Movimiento movimiento);

    @Update
    void update(Movimiento movimiento);

}
