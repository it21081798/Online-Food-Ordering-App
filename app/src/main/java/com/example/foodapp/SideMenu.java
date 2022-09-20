package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SideMenu extends AppCompatActivity {

    TextView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_menu);

        profile = findViewById(R.id.txtMenuMyProfile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMyProfile();
            }
        });

    }

    public void  goToMyProfile(){
        Intent intent = new Intent(this, UserAccount.class);
        startActivity(intent);
    }
}