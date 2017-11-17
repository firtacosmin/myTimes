package com.hawkeye.mytimes;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by CRM on 11/12/2017.
 * This is the class that will save informations about the user.
 */

public class UserInfo {
    private SharedPreferences sharedPreferences;


    public void saveEmailAndPassword(String email, String password) {
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(email, password);
            editor.apply();
        }
    }

    public void createSharePref(Context context) {
        sharedPreferences = context.getSharedPreferences("userData", Context.MODE_PRIVATE);


    }
}
