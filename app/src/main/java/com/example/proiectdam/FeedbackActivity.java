package com.example.proiectdam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proiectdam.util.Formular;
import com.example.proiectdam.util.YESORNO;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

public class FeedbackActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private RadioGroup radioGroup;
    private TextInputEditText textInputEditText;
    private Button button;
    Spinner spinner;
    public static final String FORMULAR_KEY = "formular_key";
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        spinner=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this,R.array.ItemsSpinner,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        radioGroup=findViewById(R.id.feedback_radiogroup);
        textInputEditText=findViewById(R.id.tiet_feedback);
        button = findViewById(R.id.activity_feedback_btn_submit);
        button.setOnClickListener(ClickSubmit());

        intent = getIntent();
    }

    private View.OnClickListener ClickSubmit() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()) {

                    Formular formular = createFormular();

                    intent.putExtra(FORMULAR_KEY, formular);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        };
    }


    private boolean validate() {

        if (textInputEditText.getText() == null || textInputEditText.getText().toString().trim().length() < 10) {

            Toast.makeText(getApplicationContext(),
                    R.string.invalid_tiet_feedback,
                    Toast.LENGTH_LONG)
                    .show();
            return false;
        }

        return true;
    }
    private Formular createFormular() {

        String comment ="";
                comment=textInputEditText.getText().toString();
        YESORNO  yesorno = YESORNO.YES;
        if (radioGroup.getCheckedRadioButtonId() == R.id.radioButton2) {
            yesorno = YESORNO.NO;
        }

        String category = spinner.getSelectedItem().toString();
        return new Formular(category, comment, yesorno);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String s=parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}