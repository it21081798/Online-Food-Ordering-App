package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    private Button registerButton;
    private EditText fullName, email, mobile, birthDate, password, rePassword;
    private DBHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerButton = findViewById(R.id.btnRegister);
        fullName = findViewById(R.id.inputFullName);
        email = findViewById(R.id.inputEmail);
        mobile = findViewById(R.id.inputMobile);
        birthDate = findViewById(R.id.inputBirthDate);
        password = findViewById(R.id.inputPassowrdReg);
        rePassword = findViewById(R.id.inputReEnterPasswordReg);

        context = this;
        dbHandler = new DBHandler(context);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String userFullName = fullName.getText().toString();
               String userEmail = email.getText().toString();
               String userMobile = mobile.getText().toString();
               String userBirthDate = birthDate.getText().toString();
               String userPassword = password.getText().toString();
               String userRePassword = rePassword.getText().toString();
               long regDate = System.currentTimeMillis();

               UserModel userModel = new UserModel(userFullName, userEmail, userMobile, userBirthDate, userPassword, regDate);
               dbHandler.registerUser(userModel);
            }
        });
    }

    public void goToMenuPage(){
        Intent intent = new Intent(this, SideMenu.class);
        startActivity(intent);
    }
}
