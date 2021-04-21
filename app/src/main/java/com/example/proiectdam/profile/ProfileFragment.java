package com.example.proiectdam.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.proiectdam.FeedbackActivity;
import com.example.proiectdam.R;
import com.example.proiectdam.ReviewsActivity;
import com.example.proiectdam.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.Objects;

public class ProfileFragment extends Fragment {

    public static final String NAME = "NAME";
    public static final String USER_SHARED_PREFERENCES = "USER_SHARED_PREFERENCES";
    public static final String NAME_USER = "NAME_USER";
    private TextView tvLogOut;
    private TextView tvRateApp;
    private TextView tvuser;
    private TextView tvFeedback;
    private TextView tvreviews;
    SharedPreferences pref;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.profile_fragment, container, false);
        tvuser=view.findViewById(R.id.profile_fragment_tv_user);
        pref= Objects.requireNonNull(this.getActivity()).getSharedPreferences(USER_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        String name= Objects.requireNonNull(LoginActivity.tiet_email.getText()).toString();
        SharedPreferences.Editor editor= pref.edit();
        editor.putString(NAME_USER, name);
        editor.apply(); //altfel se pierd inf
        getFromFile();
        setupViews(view);
        return view;

    }
    private void setupViews(View view){
        tvLogOut = view.findViewById(R.id.profile_fragment_tv_log_out);
        tvLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


        tvRateApp = view.findViewById(R.id.profile_fragment_tv_rate_our_app);
        tvRateApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RatingActivity.class);
                startActivity(intent);

            }
        });

        tvFeedback = view.findViewById(R.id.profile_fragment_tv_send_feedback);
        tvFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FeedbackActivity.class);
                startActivity(intent);

            }
        });
        tvreviews = view.findViewById(R.id.profile_fragment_tv_edit_profile);
        tvreviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ReviewsActivity.class);
                startActivity(intent);

            }
        });

    }


    private void getFromFile()
    {
        String name=pref.getString(NAME_USER, "");
        tvuser.setText(getString(R.string.profile_user,name));
    }
}
