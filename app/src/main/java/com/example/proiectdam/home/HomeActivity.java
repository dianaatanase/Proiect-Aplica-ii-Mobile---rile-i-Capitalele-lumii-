package com.example.proiectdam.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.proiectdam.AboutFragment;
import com.example.proiectdam.ExploreFragment;
import com.example.proiectdam.profile.ProfileFragment;
import com.example.proiectdam.R;
import com.example.proiectdam.favourite.FavoriteFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_navigation_view);
        bottomNavView.setOnNavigationItemSelectedListener(navigationListener);
        bottomNavView.setSelectedItemId(R.id.home);




    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.home:selectedFragment = new HomeFragment();
                    break;
                case R.id.explore:selectedFragment = new ExploreFragment();
                    break;
                case R.id.favorite:selectedFragment = new FavoriteFragment();
                    break;
                case R.id.about:selectedFragment = new AboutFragment();
                    break;
                case R.id.profile:selectedFragment = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,
                    selectedFragment).commit();
            return true;
        }
    };
}