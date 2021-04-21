package com.example.proiectdam.network.models;


import com.example.proiectdam.network.models.Capitala;

import java.io.Serializable;

public class Tara implements Serializable {
private String nume;
private String limbaOficiala;
        private String moneda;
private String nrTuristiAn;
private Capitala capitala;

        public Tara(String nume, String limbaOficiala, String moneda, String nrTuristiAn, Capitala capitala) {
                this.nume = nume;
                this.limbaOficiala = limbaOficiala;
                this.moneda = moneda;
                this.nrTuristiAn = nrTuristiAn;
                this.capitala = capitala;
        }

        @Override
        public String toString() {
                return "Tara{" +
                        "nume='" + nume + '\'' +
                        ", limbaOficiala='" + limbaOficiala + '\'' +
                        ", moneda='" + moneda + '\'' +
                        ", nrTuristiAn='" + nrTuristiAn + '\'' +
                        ", capitala=" + capitala +
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

        public Capitala getCapitala() {
                return capitala;
        }

        public void setCapitala(Capitala capitala) {
                this.capitala = capitala;
        }
}
