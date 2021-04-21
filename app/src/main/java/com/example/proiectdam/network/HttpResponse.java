package com.example.proiectdam.network;

import com.example.proiectdam.network.models.Continent;

import java.util.List;

public class HttpResponse {

    private List<Continent> listaContinete;

    public HttpResponse(List<Continent> listaContinete) {
        this.listaContinete = listaContinete;
    }

    public List<Continent> getListaContinete() {
        return listaContinete;
    }

    public void setListaContinete(List<Continent> listaContinete) {
        this.listaContinete = listaContinete;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "listaContinete=" + listaContinete +
                '}';
    }
}
