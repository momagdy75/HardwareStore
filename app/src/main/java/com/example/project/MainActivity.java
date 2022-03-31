package com.example.project;

import androidx.annotation.NonNull;

import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    ImageView homeImg;
    Button shopNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.drawer);
        shopNow=findViewById(R.id.button);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
         NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        toggle.syncState();
        if(savedInstanceState==null){
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new Home()).commit();
        navigationView.setCheckedItem(R.id.Home);
        }
        homeImg=findViewById(R.id.imageView4);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.Home:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new Home()).commit();
                break;
            case R.id.CPU:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new cpu()).commit();
                break;
            case R.id.GPU:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new gpu()).commit();
                break;
            case R.id.MotherBoard:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new MotherBoard()).commit();
                break;
            case R.id.RAM:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new ram()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }


    public void openGpulayout(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new gpu()).commit();
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.GPU);
    }
    public void openCpulayout(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new cpu()).commit();
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.CPU);
    }
    public void openRamlayout(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new ram()).commit();
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.RAM);
    }
    public void openMBlayout(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new MotherBoard()).commit();
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.MotherBoard);
    }
}