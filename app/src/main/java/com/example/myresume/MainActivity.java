package com.example.myresume;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar; // Eksik import satırı

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar); // toolbar nesnesi düzeltilen import ile alındı
        setSupportActionBar(toolbar); // setActionBar -> setSupportActionBar düzeltmesi yapıldı

        drawerLayout  = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_Home);
        }
    }

    // Diğer metotlar burada aynı şekilde devam ediyor...



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){


        switch (item.getItemId()) {
            case R.id.nav_Home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;

            case R.id.nav_Equipment:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EquipmentFragment()).commit();
                break;

            case R.id.nav_Important_Events:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Important_EventsFragment()).commit();
                break;

            case R.id.nav_Photos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PhotoFragment()).commit();
                break;


        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

        }

        @Override
    public void onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
        }

    }




