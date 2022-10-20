package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SideMenu extends AppCompatActivity {

    TextView profile;
    TextView home;
    TextView foodMenu;
    TextView myOrders;
    TextView reviews;
    TextView cards;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_menu);

        username = findViewById(R.id.txtUsernameInSideMenu);


        profile = findViewById(R.id.txtMenuMyProfile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMyProfile();
            }
        });


        home = findViewById(R.id.txtMenuHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMenu();
            }
        });

        reviews = findViewById(R.id.txtReview);
        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToReviews();
            }
        });

        cards = findViewById(R.id.txtCard);
        cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { goToMycards(); }
        });

        foodMenu = findViewById(R.id.txtMenuFoodMenu);
        foodMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { goToFoodMenu(); }
        });






    }

    public void  goToMyProfile(){
        Intent intent = new Intent(this, UserAccount.class);
        startActivity(intent);
    }

    public void goToMenu(){
        Intent intent = new Intent(this, SideMenu.class);
        startActivity(intent);
    }

    public void goToReviews(){
        Intent intent = new Intent(this, ListReview.class);
        startActivity(intent);
    }

    public void goToMycards(){
        Intent intent = new Intent(this,saveCardDetails.class);
        startActivity(intent);
    }

    public void  goToFoodMenu(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }





}