package com.example.proiectdam.most_popular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proiectdam.R;

public class BudapestaActivity extends AppCompatActivity {

    ImageView imgBudapest;
    TextView tvInfoBudapest;
    TextView tvNumeOrasBudapest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budapesta);

        initcomponents();
    }

    private void initcomponents() {
        imgBudapest = findViewById(R.id.praga_activity_image);
        tvInfoBudapest = findViewById(R.id.praga_activity_tv_inf);
        tvNumeOrasBudapest = findViewById(R.id.praga_activity_tv_nume_oras);
    }
}