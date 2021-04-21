package com.example.proiectdam;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proiectdam.search.SearchCountriesActivity;

public class WaitingActivity extends AppCompatActivity {
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);
        progressBar=findViewById(R.id.progressBarWaiting);
        progressBar.getIndeterminateDrawable().setColorFilter(0xB3CD8BD1, android.graphics.PorterDuff.Mode.MULTIPLY);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(WaitingActivity.this, SearchCountriesActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        }, 4000);
    }
}