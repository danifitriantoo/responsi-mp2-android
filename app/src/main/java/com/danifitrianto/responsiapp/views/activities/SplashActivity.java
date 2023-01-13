package com.danifitrianto.responsiapp.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.danifitrianto.responsiapp.MainActivity;
import com.danifitrianto.responsiapp.R;
import com.danifitrianto.responsiapp.setups.prefs.PreferencesHelper;

public class SplashActivity extends AppCompatActivity {

    private PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencesHelper = PreferencesHelper.getInstance(getApplicationContext());

        new Handler().postDelayed(new Runnable() {
            @Override

            public void run() {

                if(preferencesHelper.getCredentials() > 0) {
                    Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        }, 2000); // wait for 5 seconds

    }
}