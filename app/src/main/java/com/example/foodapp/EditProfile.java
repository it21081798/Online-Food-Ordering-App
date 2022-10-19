package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Pattern;

public class EditProfile extends AppCompatActivity {

    private static final Pattern MOBILE_PATTERN =
            Pattern.compile("[0][0-9]{9}");

    private TextView editName, editEmail, editMobile, editBirthDate;
    private Button editProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editName = findViewById(R.id.inputFirstName2);
        editEmail = findViewById(R.id.inputEmail2);
        editMobile = findViewById(R.id.inputMobile2);
        editBirthDate = findViewById(R.id.inputBirthDate2);

        editProfile = findViewById(R.id.btnEditProfile);

        SharedPreferences sharedPreferences = getSharedPreferences("session", MODE_PRIVATE);
        String name1 = sharedPreferences.getString("Name", null);
        String email1 = sharedPreferences.getString("Email", null);
        String mobile1 = sharedPreferences.getString("Mobile", null);
        String birthDate1 = sharedPreferences.getString("BirthDate", null);

        editName.setText(name1);
        editBirthDate.setText(birthDate1);
        editEmail.setText(email1);
        editMobile.setText(mobile1);

        //Calender View
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int date = calendar.get(Calendar.DAY_OF_MONTH);

        editBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(EditProfile.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                        month = month+1;
                        String day = date+"/"+month+"/"+year;
                        editBirthDate.setText(day);
                    }
                }, year, month, date);
                dialog.show();
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullName = editName.getText().toString();
                String email = editEmail.getText().toString();
                String mobile = editMobile.getText().toString();
                String birthDate = editBirthDate.getText().toString();

                if (validateName() && validateEmail() && validateMobile() && validBirthDate()){
                    Toast.makeText(getApplicationContext(), "Details Are Valid", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Details Are Invalid ", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public boolean validateEmail(){
        String userEmail = editEmail.getText().toString();
        if (userEmail.isEmpty()){
            editEmail.setError("Field Cannot be Empty !");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
            editEmail.setError("Please Enter Valid Email Address !");
            return false;
        }
        else {
            return true;
        }
    }

    public boolean validateName(){
        String userFullName = editName.getText().toString();

        if (userFullName.isEmpty()) {
            editName.setError("Field Cannot be Empty !");
            return false;
        }
        else
            return true;
    }



    public boolean validateMobile(){
        String userMobile = editMobile.getText().toString();

        if (userMobile.isEmpty()) {
            editMobile.setError("Field Cannot be Empty !");
            return false;
        }
        else if (!MOBILE_PATTERN.matcher(userMobile).matches()) {
            editMobile.setError("Please Enter a Valid Mobile Number !");
            return false;
        }
        else
            return true;
    }

    public boolean validBirthDate(){
        String userBirthDate = editBirthDate.getText().toString();

        if (userBirthDate.isEmpty()) {
            editBirthDate.setError("Field Cannot be Empty !");
            return false;
        }
        else {
            editBirthDate.setError(null);
            return true;
        }
    }


}