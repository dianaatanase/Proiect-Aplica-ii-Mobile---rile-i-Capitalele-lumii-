package com.example.proiectdam.network;

import com.example.proiectdam.network.models.Capitala;
import com.example.proiectdam.network.models.Continent;
import com.example.proiectdam.network.models.Tara;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static HttpResponse parseJson(String json) {
        if (json == null) {
            return null;
        }
        try {
            JSONObject jsonObject = new JSONObject(json);
            List<Continent> continente = getContinentListFromJson(jsonObject.getJSONArray("continente"));
            return new HttpResponse(continente);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;

    }

    private static List<Continent> getContinentListFromJson(JSONArray array) throws JSONException {
        if (array == null) {
            return null;
        }
        List<Continent> result = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            Continent continent = getContinent(array.getJSONObject(i));
            if (continent != null) {
                result.add(continent);

            }
        }
        return result;

    }


    private static Continent getContinent(JSONObject object) throws JSONException {
        String nume = object.getString("nume");
        String pozitionare = object.getString("pozitionare");
        String suprafata = object.getString("suprafata");
        List<Tara> listaTari = getTariContinente(object.getJSONArray("tari"));
        return new Continent(nume, pozitionare, suprafata, listaTari);

    }


    private static List<Tara> getTariContinente(JSONArray array) throws JSONException {
        if (array == null) {
            return null;
        }
        List<Tara> result = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            Tara tara = getTara(array.getJSONObject(i));
            result.add(tara);

        }
        return result;
    }

    private static Tara getTara(JSONObject object) throws JSONException {
        String nume = object.getString("nume");
        String limbaOficiala = object.getString("limba_oficiala");
        String moneda = object.getString("moneda");
        String nrTuristiAn = object.getString("nr_turisti_an");
        Capitala capitala = getCapitala(object.getJSONObject("capitala"));
        return new Tara(nume, limbaOficiala, moneda, nrTuristiAn, capitala);
    }

    private static Capitala getCapitala(JSONObject object) throws JSONException {
        String nume = object.getString("nume");
        String densitate = object.getString("densitate");
        List<String> obiectiveTuristice = getObiectiveTuristice(object.getJSONArray("obiective_turistice"));
        return new Capitala(nume, densitate, obiectiveTuristice);
    }


    private static List<String> getObiectiveTuristice(JSONArray array) throws JSONException {
        if (array == null) {
            return null;
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            String string = array.getString(i);
            if (string != null) {
                result.add(string);

            }
        }
        return result;
    }

}
