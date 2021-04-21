package com.example.proiectdam.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proiectdam.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.jar.Attributes;

import static java.lang.Float.parseFloat;

public class RatingActivity extends AppCompatActivity {
    public static final String RATING_PREF = "ratingPref";
    public static final String VERY_BAD = "VERY BAD ";
    public static final String RATING = "rating";
    TextInputEditText textInputEditText;
    RatingBar ratingBar;
    TextView count;
    Button submit;
    float ratingdefault=0.0f;
    private SharedPreferences preferences;
    float rateValue; String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        count=findViewById(R.id.count);
        ratingBar=findViewById(R.id.rtg1);
        textInputEditText=findViewById(R.id.tiet_feedback);
        submit=findViewById(R.id.btn_1);
        //fis de pref


        preferences=getSharedPreferences(RATING_PREF, MODE_PRIVATE);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rateValue=ratingBar.getRating();
                if(rateValue<=1 && rateValue>0)
                    count.setText(getString(R.string.very_bad,rateValue));
                if(rateValue<=2 && rateValue>1)
                    count.setText(getString(R.string.bad,rateValue));
                if(rateValue<=3 && rateValue>2)
                    count.setText(getString(R.string.ok,rateValue));
                if(rateValue<=4 && rateValue>3)
                    count.setText(getString(R.string.good,rateValue));
                if(rateValue<=5 && rateValue>4)
                    count.setText(getString(R.string.very_good,rateValue));
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            float ratingvalue=ratingBar.getRating();
            SharedPreferences.Editor editor= preferences.edit();
            editor.putFloat(RATING, ratingvalue);
            editor.apply();
                finish();


            }
        });
        getFromSP();
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {

                rateValue=ratingBar.getRating();
                if(rateValue<=1 && rateValue>0)
                    count.setText(getString(R.string.very_bad,rateValue) );
                if(rateValue<=2 && rateValue>1)
                    count.setText(getString(R.string.bad,rateValue));
                if(rateValue<=3 && rateValue>2)
                    count.setText(getString(R.string.ok,rateValue));
                if(rateValue<=4 && rateValue>3)
                    count.setText(getString(R.string.good,rateValue));
                if(rateValue<=5 && rateValue>4)
                    count.setText(getString(R.string.very_good,rateValue));

            }

        });

    }
    private void getFromSP()
    {


        float rating=preferences.getFloat(RATING, 0.0f);
        ratingBar.setRating(rating);

    }
}