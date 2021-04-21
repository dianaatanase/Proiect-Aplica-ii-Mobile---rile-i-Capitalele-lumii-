package com.example.proiectdam.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.proiectdam.database.dao.TaraDao;
import com.example.proiectdam.database.dao.TopTariDao;
import com.example.proiectdam.database.model.TaraDB;
import com.example.proiectdam.database.model.TopTari;


@Database(entities = {TaraDB.class, TopTari.class}, exportSchema = false, version = 5)
public abstract class DatabaseManager extends RoomDatabase {

    //singletone  -- private constructor
    private static final String proiect_dam = "DB_DAM";
    private static DatabaseManager databaseManager;

    public static DatabaseManager getInstance(Context context){
        if(databaseManager == null) {
            synchronized (DatabaseManager.class) {
                if (databaseManager == null) {
                    databaseManager = Room.databaseBuilder(context, DatabaseManager.class, proiect_dam)
                            .fallbackToDestructiveMigration().build();    //atunci cand facem modif asupra unei tabele
                }
            }
        }
        return databaseManager;
    }
   public abstract TaraDao taraDao();
    public  abstract TopTariDao topTariDao();
}
