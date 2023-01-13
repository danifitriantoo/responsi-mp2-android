package com.danifitrianto.responsiapp.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.danifitrianto.responsiapp.R;
import com.danifitrianto.responsiapp.models.Users;
import com.danifitrianto.responsiapp.setups.prefs.PreferencesHelper;
import com.danifitrianto.responsiapp.setups.room.DatabaseClient;

public class ProfileActivity extends AppCompatActivity {

    private EditText etEmail, etPassword, etName,etAddress;
    private Button btnUpdate;
    private ImageButton btnBack;
    private PreferencesHelper preferencesHelper;
    private Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnBack = findViewById(R.id.btnBack);

        preferencesHelper.getInstance(getApplicationContext());

        btnUpdate.setOnClickListener(view -> {
            if(!etEmail.getText().toString().isEmpty()
                    && !etName.getText().toString().isEmpty()
                    && !etAddress.getText().toString().isEmpty()) {

                    class updateData extends AsyncTask<Void, Void, Void> {
                        @Override
                        protected Void doInBackground(Void... voids) {

                            DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                                    .userDao()
                                    .updateData(
                                            etEmail.getText().toString(),
                                            etPassword.getText().toString(),
                                            etAddress.getText().toString(),
                                            etName.getText().toString(),
                                            preferencesHelper.getCredentials()

                                    );
                            

                            return null;

                    }
                }
                updateData asyncTask = new updateData();
                asyncTask.execute();
            }
        });

        btnBack.setOnClickListener(view -> finish());

    }
}