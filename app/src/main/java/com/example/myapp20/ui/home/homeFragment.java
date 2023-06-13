package com.example.myapp20.ui.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.example.myapp20.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


public class homeFragment extends Fragment {
//private SliderLayout sliderLayout;
    SliderView sliderView;
    ImageView Imagemap;
    private int[] images={ R.drawable.svm, R.drawable.svm_slider1, R.drawable.svm_slider2, R.drawable.svm_slider3};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        sliderView =view.findViewById(R.id.slider);
        Imagemap = view.findViewById(R.id.map);
        Imagemap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenMap();
            }


        });
        SliderAdapter sliderAdapter=new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.FILL);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();
        return  view;
    }

    private void OpenMap() {
        Uri uri =Uri.parse("geo:0, 0?q=SVM PUBLIC SCHOOL ARWATAND");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }


}