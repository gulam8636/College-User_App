package com.example.myapp20.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapp20.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class galleryFragment extends Fragment {
RecyclerView republicRecycler,othersRecycler;
GalleryAdapter galleryAdapter;
DatabaseReference reference;
    DatabaseReference storage;
    private  String uniqueKey;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        reference = FirebaseDatabase.getInstance().getReference().child("Image");

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);
        republicRecycler=view.findViewById(R.id.republicDay);
        othersRecycler =view.findViewById(R.id.Others);

        getRepublicImage();
        getOthersImage();
        return view;
    }

    private void getOthersImage() {
        reference.addValueEventListener(new ValueEventListener() {
            List<String> imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()) {
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }
          galleryAdapter = new GalleryAdapter(getContext(),imageList);
          othersRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
          othersRecycler.setAdapter(galleryAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "image load failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getRepublicImage() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                List<String > imageList=new ArrayList<>();
                for (DataSnapshot snapshot1:snapshot.getChildren()) {
                    String data = snapshot1.getValue().toString();
                    imageList.add(data);
                }
                galleryAdapter = new GalleryAdapter(getContext(),imageList);
                republicRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                republicRecycler.setAdapter(galleryAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}