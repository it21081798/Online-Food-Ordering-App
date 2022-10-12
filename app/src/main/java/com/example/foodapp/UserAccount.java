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
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        editProfileButton = findViewById(R.id.btnEditProfile);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToEditProfilePage();
            }
        });


        changePasswordButton = findViewById(R.id.btnChangePassword);
        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToChangePasswordPage();
            }
        });


        deleteProfileButton = findViewById(R.id.btnDeleteProfile);
        deleteProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDeleteProfilePage();
            }
        });


        logoutButton = findViewById(R.id.btnLogout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMainPage();
            }
        });

    }

    public void goToEditProfilePage(){
        Intent intent = new Intent(this, EditProfile.class);
        startActivity(intent);
    }

    public void goToChangePasswordPage(){
        Intent intent = new Intent(this, ChangePassword.class);
        startActivity(intent);
    }

    public void goToDeleteProfilePage(){
        Intent intent = new Intent(this, DeleteProfile.class);
        startActivity(intent);
    }

    public void goToMainPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}