package com.example.proiectdam.network.models;

import java.io.Serializable;
import java.util.List;

public class Capitala implements Serializable {
    private String nume;
    private String densitate;
    private List<String> obiectiveTuristice;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDensitate() {
        return densitate;
    }

    public void setDensitate(String densitate) {
        this.densitate = densitate;
    }

    public List<String> getObiectiveTuristice() {
        return obiectiveTuristice;
    }

    public void setObiectiveTuristice(List<String> obiectiveTuristice) {
        this.obiectiveTuristice = obiectiveTuristice;
    }

    public Capitala(String nume, String densitate, List<String> obiectiveTuristice) {
        this.nume = nume;
        this.densitate = densitate;
        this.obiectiveTuristice = obiectiveTuristice;
    }

    @Override
    public String toString() {
        return "Capitala{" +
                "nume='" + nume + '\'' +
                ", densitate='" + densitate + '\'' +
                ", obiectiveTuristice=" + obiectiveTuristice +
                '}';
    }
}
