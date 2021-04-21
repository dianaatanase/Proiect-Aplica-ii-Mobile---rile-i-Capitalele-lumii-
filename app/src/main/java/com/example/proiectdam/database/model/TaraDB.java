package com.example.proiectdam.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "TARADB")
public class TaraDB {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id_tara")
    private long id_tara;
    @ColumnInfo(name="nume")
    private String nume;
    @ColumnInfo(name="limbaOficiala")
    private String limbaOficiala;
    @ColumnInfo(name="moneda")
    private String moneda;
    @ColumnInfo(name="nrTuristiAn")
    private String nrTuristiAn;
    @ColumnInfo(name="denumireCapitala")
    private String denumireCapitala;
    @ColumnInfo(name="densitatePopulatieCapitala")
    private String densitatePopulatieCapitala;
    @ColumnInfo(name="obiectivTuristic1")
    private String obiectivTuristic1;
    @ColumnInfo(name="obiectivTuristic2")
    private String obiectivTuristic2;
    @ColumnInfo(name="obiectivTuristic3")
    private String obiectivTuristic3;
    public TaraDB(){

    }
    public TaraDB(long id,
                  String nume,
                  String limbaOficiala,
                  String moneda,
                  String nrTuristiAn,
                  String denumireCapitala,
                  String densitatePopulatieCapitala,
                  String obiectivTuristic1,
                  String obiectivTuristic2,
                  String obiectivTuristic3) {
        this.id_tara = id;
        this.nume = nume;
        this.limbaOficiala = limbaOficiala;
        this.moneda = moneda;
        this.nrTuristiAn = nrTuristiAn;
        this.denumireCapitala = denumireCapitala;
        this.densitatePopulatieCapitala = densitatePopulatieCapitala;
        this.obiectivTuristic1 = obiectivTuristic1;
        this.obiectivTuristic2 = obiectivTuristic2;
        this.obiectivTuristic3 = obiectivTuristic3;
    }

    public long getId_tara() {
        return id_tara;
    }

    public void setId_tara(long id_tara) {
        this.id_tara = id_tara;
    }

    @Ignore
    public TaraDB(String nume,
                  String limbaOficiala,
                  String moneda,
                  String nrTuristiAn,
                  String denumireCapitala,
                  String densitatePopulatieCapitala,
                  String obiectivTuristic1,
                  String obiectivTuristic2,
                  String obiectivTuristic3) {
        this.nume = nume;
        this.limbaOficiala = limbaOficiala;
        this.moneda = moneda;
        this.nrTuristiAn = nrTuristiAn;
        this.denumireCapitala = denumireCapitala;
        this.densitatePopulatieCapitala = densitatePopulatieCapitala;
        this.obiectivTuristic1 = obiectivTuristic1;
        this.obiectivTuristic2 = obiectivTuristic2;
        this.obiectivTuristic3 = obiectivTuristic3;
    }

    @Override
    public String toString() {
        return "TaraDB{" +
                "nume='" + nume + '\'' +
                ", limbaOficiala='" + limbaOficiala + '\'' +
                ", moneda='" + moneda + '\'' +
                ", nrTuristiAn='" + nrTuristiAn + '\'' +
                ", denumireCapitala='" + denumireCapitala + '\'' +
                ", densitatePopulatieCapitala='" + densitatePopulatieCapitala + '\'' +
                ", obiectivTuristic1='" + obiectivTuristic1 + '\'' +
                ", obiectivTuristic2='" + obiectivTuristic2 + '\'' +
                ", obiectivTuristic3='" + obiectivTuristic3 + '\'' +
                '}';
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getLimbaOficiala() {
        return limbaOficiala;
    }

    public void setLimbaOficiala(String limbaOficiala) {
        this.limbaOficiala = limbaOficiala;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getNrTuristiAn() {
        return nrTuristiAn;
    }

    public void setNrTuristiAn(String nrTuristiAn) {
        this.nrTuristiAn = nrTuristiAn;
    }

    public String getDenumireCapitala() {
        return denumireCapitala;
    }

    public void setDenumireCapitala(String denumireCapitala) {
        this.denumireCapitala = denumireCapitala;
    }

    public String getDensitatePopulatieCapitala() {
        return densitatePopulatieCapitala;
    }

    public void setDensitatePopulatieCapitala(String densitatePopulatieCapitala) {
        this.densitatePopulatieCapitala = densitatePopulatieCapitala;
    }

    public String getObiectivTuristic1() {
        return obiectivTuristic1;
    }

    public void setObiectivTuristic1(String obiectivTuristic1) {
        this.obiectivTuristic1 = obiectivTuristic1;
    }

    public String getObiectivTuristic2() {
        return obiectivTuristic2;
    }

    public void setObiectivTuristic2(String obiectivTuristic2) {
        this.obiectivTuristic2 = obiectivTuristic2;
    }

    public String getObiectivTuristic3() {
        return obiectivTuristic3;
    }

    public void setObiectivTuristic3(String obiectivTuristic3) {
        this.obiectivTuristic3 = obiectivTuristic3;
    }
}
