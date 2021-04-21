package com.example.proiectdam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AboutFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageSlider imageSlider = view.findViewById(R.id.img_slider);
        List<SlideModel> slideModelList= new ArrayList<>();
        slideModelList.add(new SlideModel(R.drawable.col,getString(R.string.over_30_countries)));

        slideModelList.add(new SlideModel(R.drawable.hello, getString(R.string.languages_available)));
        slideModelList.add(new SlideModel(R.drawable.map, getString(R.string.suggested_attractions)));
        imageSlider.setImageList(slideModelList,true);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.about_fragment, container, false);


    }
}
