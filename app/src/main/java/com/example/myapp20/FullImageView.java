package com.example.myapp20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

public class FullImageView extends AppCompatActivity {
private PhotoView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_view);
        String image =getIntent().getStringExtra("image");
        imageview = findViewById(R.id.imageView);
        Picasso.get().load(image).into(imageview);
    }
}