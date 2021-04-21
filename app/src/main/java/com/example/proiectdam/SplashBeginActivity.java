package com.example.proiectdam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashBeginActivity extends AppCompatActivity {
    private static int time_splash=6000;
    ProgressBar progressbar;
    private ProgressDialog working_dialog;
    // private Handler handler=new Handler();
    private int progressStatus=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity_begin);
        progressbar=findViewById(R.id.progressBar);
        progressbar.getProgressDrawable().setColorFilter(
                Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        new Thread(new Runnable(){

            @Override
            public void run() {
                while(progressStatus<100)
                {
                    progressStatus++;
                    android.os.SystemClock.sleep(50);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressbar.setProgress(progressStatus);
                        }
                    }, 700);

                }
            }
        }).start();






/*

        CountDownTimer cdt = new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {

                progressbar.setProgress(Math.abs(100- (int) millisUntilFinished/10));
               // total = (int) ((timePassed / 60) * 100);
               // progressbar.setProgress(total);
            }

            @Override
            public void onFinish() {

            }


     }.start(); */

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashBeginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, time_splash);

        final ImageView img1 = findViewById(R.id.splash1);
        final ImageView img2 = findViewById(R.id.splash2);
        final ImageView img3 = findViewById(R.id.splash3);
        final ImageView img4 = findViewById(R.id.splash4);
        final ImageView img5 = findViewById(R.id.logo);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                img1.setVisibility(View.VISIBLE);
            }
        }, 1000);


        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                img2.setVisibility(View.VISIBLE);
            }
        }, 2000);


        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                img3.setVisibility(View.VISIBLE);
            }
        }, 3000);


        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                img4.setVisibility(View.VISIBLE);
            }
        }, 4000);


        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                img5.setVisibility(View.VISIBLE);
            }
        }, 5000);

    }
}
