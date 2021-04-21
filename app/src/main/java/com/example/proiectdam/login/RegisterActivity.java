package com.example.proiectdam.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proiectdam.home.HomeActivity;
import com.example.proiectdam.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private TextView tvRegister;


    private TextInputLayout tilFullName;
    public static TextInputEditText tietFullName;

    private TextInputLayout tilPhoneNumber;
    private TextInputEditText tietPhoneNumber;

    private TextInputLayout tilEmail;
    private TextInputEditText tietEmail;

    private TextInputLayout tilPassword;
    private TextInputEditText tietPassword;

    private TextInputLayout tilConfirmPassword;
    private TextInputEditText tietConfirmPassword;

    private Button btnRegister;
    private TextView tv_login_message;

    private ProgressBar progressBar;

    //FIREBASE
    FirebaseAuth fireBaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initComponents();

        //firebase
        fireBaseAuth = FirebaseAuth.getInstance();

//        if(fireBaseAuth.getCurrentUser() != null){
//            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//            startActivity(intent);
//            finish();
//        }


        // click tv log in message
        tv_login_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        //click pe butonul de register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validari()) {
                    String email = tietEmail.getText().toString().trim();
                    String password = tietPassword.getText().toString().trim();

                    if (tietEmail.getText() == null || tietEmail.getText().toString().trim().length() < 8) {
                        tietEmail.setError(getString(R.string.invalid_email));
                        return;
                    }

                    if (isEmailValid((CharSequence) tietEmail.getText().toString())) {
                        if (tietPassword.getText() == null || tietPassword.getText().toString().trim().length() < 8) {
                            tietPassword.setError(getString(R.string.invalid_password));
                            return;
                        }

                        progressBar.setVisibility(View.VISIBLE);

                        // INREGISTRAREA IN FIREBASE
                        fireBaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                            R.string.register_activity_user_created_message,
                                            Toast.LENGTH_LONG)
                                            .show();
                                    progressBar.setVisibility(View.INVISIBLE);
                                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    Toast.makeText(getApplicationContext(),
                                            R.string.register_activity_user_created_error_message + task.getException().getMessage(),
                                            Toast.LENGTH_LONG)
                                            .show();
                                }
                            }
                        });
                    } else {
                        tietEmail.setError(getString(R.string.invalid_email));
                    }
                }
            }
        });


    }

    private boolean validari() {

        //validare full name
        if(tietFullName.getText() == null || tietFullName.getText().toString().length() <2)
        {
            tietFullName.setError(getString(R.string.invalid_name));
            return false;
        }

        //phoneNumber
        if(tietPhoneNumber.getText() == null || tietPhoneNumber.getText().toString().length() <5)
        {
            tietPhoneNumber.setError(getString(R.string.invalid_phone_number));
            return false;
        }

        //validare conf parola
        if(tietConfirmPassword.getText() == null ||!(tietConfirmPassword.getText().toString().equals(tietPassword.getText().toString())))
        {
            tietConfirmPassword.setError(getString(R.string.password_dont_match));
            return false;
        }

        return true;
    }

    private void initComponents() {
        tvRegister = findViewById(R.id.register_activity_tv_register);

        tilFullName = findViewById(R.id.register_activity_til_fulltName);
        tietFullName = findViewById(R.id.register_activity_tiet_fullName);

        tilPhoneNumber = findViewById(R.id.register_activity_til_phone_number);
        tietPhoneNumber = findViewById(R.id.register_activity_tiet_phone_number);

        tilEmail = findViewById(R.id.register_activity_til_email);
        tietEmail = findViewById(R.id.register_activity_tiet_email);

        tilPassword = findViewById(R.id.register_activity_til_password);
        tietPassword = findViewById(R.id.register_activity_tiet_password);

        tilConfirmPassword = findViewById(R.id.register_activity_til_confirm_password);
        tietConfirmPassword = findViewById(R.id.register_activity_tiet_confirm_password);

        btnRegister = findViewById(R.id.register_activity_btn_register);

        tv_login_message = findViewById(R.id.register_activity_tv_login);

        progressBar =  findViewById(R.id.register_activity_progress_bar);

    }

    public boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}