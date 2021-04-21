package com.example.proiectdam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.proiectdam.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    MediaPlayer mediaPlayer;
    int currentVideoPosition;

    private Button btnGetInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.video_sign_in_layout_video_view);
        btnGetInfo = findViewById(R.id.video_sign_in_layout_btn_info);
        btnGetInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


        Uri uri = Uri.parse("android.resource://"
                + getPackageName()
                + "/"
                + R.raw.video2);


        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                MainActivity.this.mediaPlayer = mediaPlayer;
                MainActivity.this.mediaPlayer.setLooping(true);
                if (currentVideoPosition != 0) {
                    MainActivity.this.mediaPlayer.seekTo(currentVideoPosition);
                    MainActivity.this.mediaPlayer.start();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        currentVideoPosition = mediaPlayer.getCurrentPosition();
        videoView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mediaPlayer.release();
        mediaPlayer = null;
    }
}