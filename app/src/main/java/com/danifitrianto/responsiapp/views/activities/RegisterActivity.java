package com.danifitrianto.responsiapp.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.danifitrianto.responsiapp.R;
import com.danifitrianto.responsiapp.models.Users;
import com.danifitrianto.responsiapp.setups.room.DatabaseClient;

public class RegisterActivity extends AppCompatActivity {

    private EditText etEmail, etPassword, etConfirm;
    private Button btnRegister,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirm = findViewById(R.id.etConfirm);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(view -> {
            if(!etEmail.getText().toString().isEmpty()
                    && !etPassword.getText().toString().isEmpty()
                    && !etConfirm.getText().toString().isEmpty()) {
                if(etPassword.getText().toString().equals(etConfirm.getText().toString())) {

                    Users model = new Users(
                            etEmail.getText().toString(),
                            etConfirm.getText().toString()
                    );

                    class registerTaslAsync extends AsyncTask<Void, Void, Void> {

                        @Override
                        protected Void doInBackground(Void... voids) {
                            DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                                    .userDao()
                                    .insert(model);

                            return null;
                        }

                    }
                    registerTaslAsync task = new registerTaslAsync();
                    task.execute();
                }
            }
        });

        btnBack.setOnClickListener(view -> finish());

    }
}