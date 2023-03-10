package com.danifitrianto.responsiapp.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.danifitrianto.responsiapp.R;
import com.danifitrianto.responsiapp.models.Users;
import com.danifitrianto.responsiapp.setups.prefs.PreferencesHelper;
import com.danifitrianto.responsiapp.setups.room.DatabaseClient;

public class RegisterActivity extends AppCompatActivity {

    private EditText etEmail, etPassword, etConfirm;
    private Button btnRegister;
    private ImageButton btnBack;
    private PreferencesHelper preferencesHelper;
    private Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnBack = findViewById(R.id.btnBack);
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

                            users = DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                                    .userDao()
                                    .checkCredetials(etEmail.getText().toString(), etPassword.getText().toString());


                            if(users != null) {
                                preferencesHelper.getInstance(getApplicationContext())
                                        .setCredentials(users.getUser_id());


                                Intent i = new Intent(RegisterActivity.this,HomeActivity.class);
                                startActivity(i);
                            }

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