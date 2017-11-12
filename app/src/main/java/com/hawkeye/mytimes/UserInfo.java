package com.hawkeye.mytimes;

import java.util.HashMap;

/**
 * Created by CRM on 11/12/2017.
 * This is the clas that will save informations about the user.
 */

public class UserInfo {
    HashMap <String,String> userMap= new HashMap<>();

    public void saveEmailAndPassword(String email,String password){
        userMap.put(email,password);
    }
}
