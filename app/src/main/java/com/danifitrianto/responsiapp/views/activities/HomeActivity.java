package com.danifitrianto.responsiapp.views.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.danifitrianto.responsiapp.R;
import com.danifitrianto.responsiapp.views.fragments.HistoryFragment;
import com.danifitrianto.responsiapp.views.fragments.HomeFragment;
import com.danifitrianto.responsiapp.views.fragments.PaymentFragment;
import com.danifitrianto.responsiapp.views.fragments.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private ImageButton btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottonnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        btnProfile = findViewById(R.id.btnAccount);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });

        loadFragment(new HomeFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                loadFragment(new HomeFragment());
                ;
                break;
            case R.id.history:
                loadFragment(new HistoryFragment());
                break;
            case R.id.payment:
                loadFragment(new PaymentFragment());
                break;
            case R.id.setting:
                loadFragment(new SettingFragment());
                break;
        }
        return true;
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout,fragment);
        ft.commit();
    }

//    private void statusBroadcast() {
//        registerReceiver(StatusReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
//    }

}