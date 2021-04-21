package com.example.proiectdam.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.proiectdam.database.model.TopTari;
@Dao
public interface TopTariDao {
    @Insert
    long insert(TopTari topTari);
}
