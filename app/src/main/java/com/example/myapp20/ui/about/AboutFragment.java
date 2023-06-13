package com.example.myapp20.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapp20.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

private ViewPager viewPager;
private ClassAdapter adapter;
private List<ClassModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_about, container, false);
        list =new ArrayList<>();
        list.add(new ClassModel(R.drawable.ic_nursery,"Nursery","Nusery Class is being conducted since 2012"));
        list.add(new ClassModel(R.drawable.ic_tenth,"Standard Tenth","Our top Class is being conducted since 2012"));
        adapter =new ClassAdapter(getContext(),list);
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        ImageView imageView = view.findViewById(R.id.schoolImg);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/svm-public-school.appspot.com/o/Image%2F-NX-od-Tpo_luF8rlBgT?alt=media&token=bbeeccff-200f-4335-8212-3a2a9a85fcdb&_gl=1*omty6e*_ga*NTE5NTIwODU3LjE2ODQwNDc5MzI.*_ga_CW55HF8NVT*MTY4NTc4ODY0NS4zNS4xLjE2ODU3ODg4NTEuMC4wLjA.").into(imageView);

        return view;
    }
}