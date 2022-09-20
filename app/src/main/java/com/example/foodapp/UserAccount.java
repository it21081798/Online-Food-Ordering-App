package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserAccount extends AppCompatActivity {

    private Button editProfileButton;
    private Button changePasswordButton;
    private Button deleteProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        editProfileButton = (Button) findViewById(R.id.btnEditProfile);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditProfilePage();
            }
        });


        changePasswordButton = (Button) findViewById(R.id.btnChangePassword);
        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChangePasswordPage();
            }
        });

        deleteProfileButton = (Button) findViewById(R.id.btnDeleteProfile);
        deleteProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDeleteProfilePage();
            }
        });
    }

    public void openEditProfilePage(){
        Intent intent = new Intent(this, EditProfile.class);
        startActivity(intent);
    }

    public void openChangePasswordPage(){
        Intent intent = new Intent(this, ChangePassword.class);
        startActivity(intent);
    }

    public void openDeleteProfilePage(){
        Intent intent = new Intent(this, DeleteProfile.class);
        startActivity(intent);
    }
}