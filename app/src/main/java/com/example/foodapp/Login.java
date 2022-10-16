package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.webkit.SafeBrowsingResponse;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-zA-Z])" +      //any letter
                    ".{8,}" +               //at least 8 characters
                    "$");

    private Button loginButtonInLogin;
    private EditText username, password;
    private TextView didntHaveAccount;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButtonInLogin = (Button) findViewById(R.id.btnLogin2);
        username = findViewById(R.id.inputUsername);
        password = findViewById(R.id.inputPasswordLogin);
        didntHaveAccount = findViewById(R.id.txtDidntHaveAccount);
        dbHandler = new DBHandler(this);

        loginButtonInLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userEmail = username.getText().toString();
                String userPassword = password.getText().toString();
                boolean res = dbHandler.login(userEmail, userPassword);

                if (validateEmail() && validatePassword()){
                    if (res) {
                        Toast.makeText(getApplicationContext(), "Login Successful ", Toast.LENGTH_LONG).show();
                        openProfile();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "User Not Found !", Toast.LENGTH_LONG).show();                   }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Invalid Login Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        didntHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisterPage();
            }
        });
    }


    public void openProfile(){
        Intent intent = new Intent(this, SideMenu.class);
        startActivity(intent);
    }

    public void openRegisterPage(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }


    public boolean validatePassword(){
        String userPassword = password.getText().toString();

        if (userPassword.isEmpty()){
            password.setError("Fields Cannot be Empty !");
            return false;
        }
        else if (!PASSWORD_PATTERN.matcher(userPassword).matches()){
            password.setError("Password Must Contain Minimum 8 characters, At least One Digit and At least One Letter");
            return false;
        }
        else
            return true;
    }


    public boolean validateEmail(){
        String userEmail = username.getText().toString();
        if (userEmail.isEmpty()){
            username.setError("Field Cannot be Empty !");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
            username.setError("Please Enter Valid Email Address !");
            return false;
        }
        else {
            return true;
        }
    }

    public void login(View view){
        UserModel userModel = new UserModel()
        SessionManagement sessionManagement = new SessionManagement((Login.this));
        sessionManagement.saveSession();
    }
}

//add loyalty customers