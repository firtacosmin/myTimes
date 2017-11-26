package com.hawkeye.mytimes;

import android.content.Context;
import android.content.SharedPreferences;

import com.hawkeye.mytimes.utils.Consts;

import java.util.Objects;

/**
 * Created by CRM on 11/12/2017.
 * This is the class that will save informations about the user.
 */

public class UserInfo {
    private SharedPreferences accountSharedPreferences;
    private SharedPreferences appDataSharedPreferences;

    public void createSharePref(Context context) {
        accountSharedPreferences = context.getSharedPreferences(Consts.SHARED_PREFS_ACCOUNTS, Context.MODE_PRIVATE);
        appDataSharedPreferences = context.getSharedPreferences(Consts.SHARED_PREFS_APP_DATA, Context.MODE_PRIVATE);
    }
    public void saveEmailAndPassword(String email, String password) {
        if (accountSharedPreferences != null) {
            SharedPreferences.Editor editor = accountSharedPreferences.edit();
            editor.putString(email, password);
            editor.apply();
        }
    }
    public boolean loginUser(String emailLogin, String passwordLogin) {
        String shareprefpas = accountSharedPreferences.getString(emailLogin, "");
        if (Objects.equals(shareprefpas, "")) {
            return false;
        } else if (shareprefpas.equals(passwordLogin)) {
            saveLogedinEmail(emailLogin);
            return true;
        } else {
            return false;
        }
    }
    public boolean isLoggedInUser(){
        if(appDataSharedPreferences.getString(Consts.SHARED_PREFS_KEY_LOGIN,null) != null){
            return true;
        }else {
            return false;
        }
    }
    public void logout(){
        SharedPreferences.Editor editor = appDataSharedPreferences.edit();
        editor.remove(Consts.SHARED_PREFS_KEY_LOGIN);
        editor.apply();
    }
    private void saveLogedinEmail(String e_mail) {
        if (appDataSharedPreferences != null) {
            SharedPreferences.Editor editor = appDataSharedPreferences.edit();
            editor.putString(Consts.SHARED_PREFS_KEY_LOGIN, e_mail);
            editor.apply();
        }
    }
}

