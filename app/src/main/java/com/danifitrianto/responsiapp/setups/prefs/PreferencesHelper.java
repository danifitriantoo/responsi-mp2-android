package com.danifitrianto.responsiapp.setups.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Shader;

public class PreferencesHelper {
    private static final String PACKAGE_NAME = "com.danifitrianto.responsiapp";
    private static PreferencesHelper INSTANCE;
    private SharedPreferences sharedPreferences;

    private PreferencesHelper(Context context) {
        sharedPreferences = context
                .getApplicationContext()
                .getSharedPreferences(PACKAGE_NAME,Context.MODE_PRIVATE);
    }

    public static PreferencesHelper getInstance(Context context) {
        if(INSTANCE == null) {
            INSTANCE = new PreferencesHelper(context);
        }
        return INSTANCE;
    }

    public SharedPreferences preferences() {
        return sharedPreferences;
    }

    public void setCredentials(int uid)
    {
        sharedPreferences.edit().putInt("id", uid).apply();
    }


    public int getCredentials() {
        return sharedPreferences.getInt("id", 0);
    }

}
