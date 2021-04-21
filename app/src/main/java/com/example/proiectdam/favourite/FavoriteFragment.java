package com.example.proiectdam.favourite;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proiectdam.R;
import com.example.proiectdam.database.model.TaraDB;
import com.example.proiectdam.database.service.TaraService;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {


    private List<TaraDB> listaTari = new ArrayList<>();
    ListView listView;
    FavouriteAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.favorite_fragment, container, false);

        initComponents(view);
        getAll();

        return view;
    }

    @SuppressLint("StaticFieldLeak")
    private void getAll() {
        new TaraService.GetAll(getContext()) {
            @Override
            protected void onPostExecute(List<TaraDB> taraDBS) {
                listaTari.addAll(taraDBS);
                adapter.notifyDataSetChanged();


            }
        }.execute();
    }
    private void initComponents(View view){
        listView=view.findViewById(R.id.fav_country_list);
         adapter=new FavouriteAdapter(getContext(),R.layout.favourite_country,getLayoutInflater(),listaTari);
         listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog dialog=new AlertDialog.Builder(getContext())
                        .setTitle(R.string.favorite_fragment_delete_title)
                        .setMessage(R.string.favourite_fragment_delete_question)
                        .setPositiveButton(R.string.fav_fragment_yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                stergeTara(listaTari.get(position));
                              //  adapter.notifyDataSetChanged();
                               // listView.invalidateViews();
                            }
                        })
                        .setNegativeButton(R.string.fav_fragment_no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(), R.string.favorite_fragment_no_delete_message, Toast.LENGTH_LONG).show();
                            }
                        })
                        .create();
                dialog.show();
                return true;
            }
        });

    }
    private void stergeTara(TaraDB tara) {
        new TaraService.StergeTara(getContext()) {
            @Override
            protected void onPostExecute(Integer integer) {
            adapter.notifyDataSetChanged();
            listView.invalidateViews();
            }
        }.execute(tara);
    }

}