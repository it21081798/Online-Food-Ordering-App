package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    Button loginButtonInLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButtonInLogin = (Button) findViewById(R.id.btnLogin2)  ;
        loginButtonInLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfile();
            }
        });
    }

    public void openProfile(){
        Intent intent = new Intent(this, SideMenu.class);
        startActivity(intent);
    }
}

//add loyalty customers