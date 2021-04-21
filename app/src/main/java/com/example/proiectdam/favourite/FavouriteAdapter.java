package com.example.proiectdam.favourite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proiectdam.R;
import com.example.proiectdam.database.model.TaraDB;
import com.example.proiectdam.network.models.Tara;

import java.util.ArrayList;
import java.util.List;

public class FavouriteAdapter extends ArrayAdapter<TaraDB> {
    private Context context;
    private int resurce;
    private List<TaraDB> listTaraDB;
    private LayoutInflater layoutInflater;

    public FavouriteAdapter(@NonNull Context context, int resource, LayoutInflater layoutInflater, @NonNull List<TaraDB> taraDBS) {
        super(context, resource, taraDBS);
        this.context = context;
        this.resurce = resource;
        this.listTaraDB=taraDBS;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=layoutInflater.inflate(resurce,parent,false);
        TaraDB country=listTaraDB.get(position);
        if(country!=null){
            addName(view, country.getNume());
            addCapital(view,country.getDenumireCapitala());
            addCurrency(view, country.getMoneda());
            addLanguage(view, country.getLimbaOficiala());

        }
        return  view;
    }
    private void addName(View view,String name){
        TextView text= view.findViewById(R.id.fav_country_activity_custom_tv_nume_tara);
        text.setText(name);
    }

    private void addCapital(View view,String capital){
        TextView text= view.findViewById(R.id.fav_country_activity_custom_tv_nume_capitala);
        text.setText(capital);
    }

    private void addCurrency(View view,String currency){
        TextView text= view.findViewById(R.id.fav_country_activity_custom_tv_currency);
        text.setText(currency);
    }

    private void addLanguage(View view,String lang){
        TextView text= view.findViewById(R.id.fav_country_activity_custom_tv_language);
        text.setText(lang);
    }

}