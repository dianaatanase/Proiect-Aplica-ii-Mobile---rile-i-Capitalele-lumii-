package com.example.proiectdam.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proiectdam.home.HomeActivity;
import com.example.proiectdam.profile.ProfileFragment;
import com.example.proiectdam.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    public static final int Request_Code = 222;
    private TextView tv_login;
    private TextInputLayout til_email;
    public static TextInputEditText tiet_email;
    private TextInputLayout til_password;
    private TextInputEditText tiet_password;
    private Button btn_login;
    private TextView tv_register_message;
    private TextView tvuser;

    ProgressBar progressBar;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();

        //click pe tv register message
        tv_register_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //deschidere Register activity
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validari()) {
                    progressBar.setVisibility(View.VISIBLE);
                    fAuth.signInWithEmailAndPassword(tiet_email.getText().toString(), tiet_password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),
                                        R.string.login_activity_succesfull_logged_in,
                                        Toast.LENGTH_LONG)
                                        .show();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivityForResult(intent, Request_Code);
                            }else{
                                Toast.makeText(getApplicationContext(),
                                        R.string.login_activity_user_not_existing_error_message + task.getException().getMessage(),
                                        Toast.LENGTH_LONG)
                                        .show();
                                progressBar.setVisibility(View.GONE);
                                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(),
                                        R.string.error_register_first,
                                        Toast.LENGTH_LONG)
                                        .show();
                            }
                            finish();
                        }
                    });
                }
            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==Request_Code)
        {
            SharedPreferences preferences=getSharedPreferences(ProfileFragment.USER_SHARED_PREFERENCES,MODE_PRIVATE);
            String name=preferences.getString(ProfileFragment.NAME, "");
            if(name!=null)
            {
             tvuser.setText(getString(R.string.profile_user, name));
            }
        }
    }




    private boolean validari() {
        //validare email
        if(tiet_email.getText() == null || tiet_email.getText().toString().trim().length() <8 ){
            Toast.makeText(getApplicationContext(),
                    R.string.add_invalid_email_error,
                    Toast.LENGTH_LONG)
                    .show();
            tiet_email.setError(getString(R.string.error_email_invalid));
            return false;
        }

        //validare parola
        if(tiet_password.getText() == null || tiet_password.getText().toString().trim().length() <8){
            Toast.makeText(getApplicationContext(),
                    R.string.add_invalid_password_error,
                    Toast.LENGTH_LONG)
                    .show();
            return false;
        }

        return true;
    }

    private void initComponents() {
        tv_login = findViewById(R.id.login_activity_tv_login);
        til_email = findViewById(R.id.login_activity_til_email);
        tiet_email = findViewById(R.id.login_activity_tiet_email);
        til_password = findViewById(R.id.login_activity_til_password);
        tiet_password = findViewById(R.id.login_activity_tiet_password);
        btn_login = findViewById(R.id.login_activity_btn_login);
        tv_register_message =  findViewById(R.id.login_activity_tv_register);

        progressBar = findViewById(R.id.login_activity_progress_bar);
        fAuth = FirebaseAuth.getInstance();
        tvuser=findViewById(R.id.profile_fragment_tv_user);
    }
}