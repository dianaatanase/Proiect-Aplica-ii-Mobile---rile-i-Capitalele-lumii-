package com.example.proiectdam.most_popular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proiectdam.R;

public class RomaActivity extends AppCompatActivity {

    ImageView img;
    TextView tvInfo;
    TextView tvNumeOras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roma);

        initcomponents();
    }

    private void initcomponents() {
        img = findViewById(R.id.praga_activity_image);
        tvInfo = findViewById(R.id.praga_activity_tv_inf);
        tvNumeOras = findViewById(R.id.praga_activity_tv_nume_oras);
    }
}