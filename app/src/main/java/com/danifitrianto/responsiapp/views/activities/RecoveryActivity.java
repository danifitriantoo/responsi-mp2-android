package com.danifitrianto.responsiapp.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.danifitrianto.responsiapp.R;

public class RecoveryActivity extends AppCompatActivity {

    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view -> finish());


    }
}