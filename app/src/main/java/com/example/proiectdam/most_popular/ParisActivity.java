package com.example.proiectdam.most_popular;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;

import com.example.proiectdam.R;

public class ParisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paris);
        ViewPager viewPager = findViewById(R.id.paris_activity_view_pager);
        ParisAdapter adapter = new ParisAdapter(this);
        viewPager.setAdapter(adapter);
    }
}