package com.example.proiectdam.database.model;

import android.view.WindowId;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "TOPTARI", foreignKeys = @ForeignKey(entity = TaraDB.class, parentColumns = "id_tara", childColumns = "id", onDelete = ForeignKey.CASCADE))
public class TopTari {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;
    @ColumnInfo(name = "nrVizualizari")
    private int nrVizualizari;
    @ColumnInfo(name = "id_tara")
    private long id_tara;
    public TopTari(){

    }
    @Override
    public String toString() {
        return "TopTari{" +
                "id=" + id +
                ", nrVizualizari=" + nrVizualizari +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNrVizualizari() {
        return nrVizualizari;
    }

    public void setNrVizualizari(int nrVizualizari) {
        this.nrVizualizari = nrVizualizari;
    }

    @Ignore
    public TopTari(long id, int nrVizualizari) {
        this.id = id;
        this.nrVizualizari = nrVizualizari;
    }

    @Ignore
    public TopTari(long id, int nrVizualizari, long id_tara) {
        this.id = id;
        this.nrVizualizari = nrVizualizari;
        this.id_tara = id_tara;
    }

    @Ignore
    public TopTari(int nrVizualizari, long id_tara) {
        this.nrVizualizari = nrVizualizari;
        this.id_tara = id_tara;
    }

    public long getId_tara() {
        return id_tara;
    }

    public void setId_tara(long id_tara) {
        this.id_tara = id_tara;
    }
}
