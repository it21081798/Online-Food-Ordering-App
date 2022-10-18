package com.example.foodapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.style.IconMarginSpan;

public class SessionManagement {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    final String SHARED_PREF_NAME = "session";
    final String SESSION_KEY = "user_session";

    public SessionManagement(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(UserModel users){
        int id = users.getId();
        String name = users.getFullName();
        String email = users.getEmail();
        String mobile = users.getMobile();
        String birthDate = users.getBrithDate();
        String password = users.getPassword();

        editor.putInt(SESSION_KEY, id).commit();
        editor.putString("Name", name).commit();
        editor.putString("Mobile", mobile).commit();
        editor.putString("Email", email).commit();
        editor.putString("BirthDate", birthDate).commit();
        editor.putString("Password", password).commit();
    }

    public int getSession(){
        return sharedPreferences.getInt(SESSION_KEY, -1);
    }

    public void removeSession(){
        editor.putInt(SESSION_KEY, -1).commit();
    }


}
