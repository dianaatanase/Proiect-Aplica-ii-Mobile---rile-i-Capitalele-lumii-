package com.example.proiectdam.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.proiectdam.database.model.TaraDB;

import java.util.List;

@Dao
public interface TaraDao {
    @Insert
    long insert(TaraDB taraDB);
    @Query("SELECT* FROM TaraDB")
    List<TaraDB> gatAll();
    @Delete
    int stergeTara(TaraDB taraDB);
}
