package com.danifitrianto.responsiapp.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.danifitrianto.responsiapp.R;
import com.danifitrianto.responsiapp.models.Users;
import com.danifitrianto.responsiapp.setups.room.DatabaseClient;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView btnPassword,btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnPassword = findViewById(R.id.btnPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(view -> {

            if(!etEmail.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()) {

                class authTaslAsync extends AsyncTask<Void, Void, Void> {

                    @Override
                    protected Void doInBackground(Void... voids) {
                        Users credential = new Users("", "");

                        credential = DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                                .userDao()
                                .checkCredetials(etEmail.getText().toString(), etPassword.getText().toString());

                        if (credential.getEmail().isEmpty()) {
                            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(i);
                        }
                        return null;
                    }
                }
                authTaslAsync task = new authTaslAsync();
                task.execute();
            }

        });

        btnRegister.setOnClickListener(view -> {

            Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(i);
        });

        btnPassword.setOnClickListener(view -> {

            Intent i = new Intent(LoginActivity.this,RecoveryActivity.class);
            startActivity(i);
        });
    }
}