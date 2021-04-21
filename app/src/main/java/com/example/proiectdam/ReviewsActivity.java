package com.example.proiectdam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proiectdam.util.Formular;

import java.util.ArrayList;
import java.util.List;

public class ReviewsActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 222;
    private Button button;
    private ListView listReviews;
    private List<Formular> formulars=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        button=findViewById(R.id.btn_review);
        listReviews=findViewById(R.id.lv_reviews);
        addFormular();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FeedbackActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {

            Formular formular = (Formular) data.getSerializableExtra(FeedbackActivity.FORMULAR_KEY);
            if (formular != null) {
                Toast.makeText(getApplicationContext(),R.string.ty_feedback,
                        Toast.LENGTH_LONG).show();
                formulars.add(formular);

                ArrayAdapter adapter = (ArrayAdapter) listReviews.getAdapter();

                adapter.notifyDataSetChanged();
            }
        }
    }

    private void addFormular() {
        ArrayAdapter<Formular> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, formulars);
        listReviews.setAdapter(adapter);
    }
}