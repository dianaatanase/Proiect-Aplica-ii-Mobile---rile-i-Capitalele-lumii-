package com.example.proiectdam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proiectdam.database.model.TaraDB;
import com.example.proiectdam.database.model.TopTari;

import java.util.List;

public class TopTariAdapter extends  ArrayAdapter<TopTari> {
    private Context context;
    private int resurce;
    private List<TopTari> listTopTariDB;
    private LayoutInflater layoutInflater;

    public TopTariAdapter(@NonNull Context context, int resource, LayoutInflater layoutInflater, @NonNull List<TopTari> topTariDB) {
        super(context, resource, topTariDB);
        this.context = context;
        this.resurce = resource;
        this.listTopTariDB = topTariDB;
        this.layoutInflater = layoutInflater;
    }
}

