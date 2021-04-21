package com.example.proiectdam.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.proiectdam.R;
import com.example.proiectdam.WaitingActivity;
import com.example.proiectdam.most_popular.BudapestaActivity;
import com.example.proiectdam.most_popular.ParisActivity;
import com.example.proiectdam.most_popular.ParisAdapter;
import com.example.proiectdam.most_popular.PragaActivity;
import com.example.proiectdam.most_popular.RomaActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class HomeFragment extends Fragment {

    private Button btnSelectCountry;
    private Button btnParis;
    private Button btnRoma;
    private Button btnBudapest;
    private Button btnPraga;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        setupViews(view);
        return view;
    }



    private void setupViews(View view){
        btnSelectCountry =view.findViewById(R.id.home_fragment_btn_select_country);
        btnSelectCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WaitingActivity.class);
                startActivity(intent);

            }
        });

        btnParis =view.findViewById(R.id.btn_1);
        btnParis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ParisActivity.class);
                startActivity(intent);

            }
        });

        btnRoma =view.findViewById(R.id.btn_2);
        btnRoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RomaActivity.class);
                startActivity(intent);

            }
        });

        btnBudapest =view.findViewById(R.id.btn_3);
        btnBudapest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BudapestaActivity.class);
                startActivity(intent);

            }
        });

        btnPraga =view.findViewById(R.id.btn_4);
        btnPraga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PragaActivity.class);
                startActivity(intent);

            }
        });


    }

}

