package com.example.proiectdam.most_popular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proiectdam.R;

public class PragaActivity extends AppCompatActivity {

    ImageView imgPraga;
    TextView tvInfoPraga;
    TextView tvNumeOrasPraga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praga);
        initcomponents();
    }

    private void initcomponents() {
        imgPraga = findViewById(R.id.praga_activity_image);
        tvInfoPraga = findViewById(R.id.praga_activity_tv_inf);
        tvNumeOrasPraga = findViewById(R.id.praga_activity_tv_nume_oras);
    }
}