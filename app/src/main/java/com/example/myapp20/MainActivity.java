package com.example.myapp20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapp20.Ebook.EbookActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private BottomNavigationView bottomNavigationView;
private DrawerLayout drawerLayout;
private ActionBarDrawerToggle toggle;
private NavigationView navigationView;
private NavController navController;
    ArrayList<Integer> arrayList=new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView= findViewById(R.id.bottomNavigationView);
        navController= Navigation.findNavController(MainActivity.this,R.id.frame_layout);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
        drawerLayout =findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.navigation_developer){
            Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();
        }
       else if(item.getItemId()==R.id.navigation_video){
            Toast.makeText(this, "Video", Toast.LENGTH_SHORT).show();
        }
      else  if(item.getItemId()==R.id.navigation_review){
            Toast.makeText(this, "Rate", Toast.LENGTH_SHORT).show();
        }
       else if(item.getItemId()==R.id.navigation_ebook){
            startActivity(new Intent(this, EbookActivity.class));
        }
      else  if(item.getItemId()==R.id.navigation_theme){
            Toast.makeText(this, "Theme", Toast.LENGTH_SHORT).show();
        }
       else  if(item.getItemId()==R.id.navigation_website){
            Toast.makeText(this, "Website", Toast.LENGTH_SHORT).show();
        }
      else  if(item.getItemId()==R.id.navigation_share){
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        super.onBackPressed();
    }
}