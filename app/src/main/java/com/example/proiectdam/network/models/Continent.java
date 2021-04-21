package com.example.proiectdam.network.models;

import java.io.Serializable;
import java.util.List;

public class Continent implements Serializable {
    private String nume;
    private String pozitionare;
    private String suprafata;
    private List<Tara> tari;

    public Continent(String nume, String pozitionare, String suprafata, List<Tara> tari) {
        this.nume = nume;
        this.pozitionare = pozitionare;
        this.suprafata = suprafata;
        this.tari = tari;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPozitionare() {
        return pozitionare;
    }

    public void setPozitionare(String pozitionare) {
        this.pozitionare = pozitionare;
    }

    public String getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(String suprafata) {
        this.suprafata = suprafata;
    }

    public List<Tara> getTari() {
        return tari;
    }

    public void setTari(List<Tara> tari) {
        this.tari = tari;
    }

    @Override
    public String toString() {
        return "Continent{" +
                "nume='" + nume + '\'' +
                ", pozitionare='" + pozitionare + '\'' +
                ", suprafata='" + suprafata + '\'' +
                ", tari=" + tari +
                '}';
    }
}
