package com.example.foodapp;

public class UserModel {
    private int id;
    private String fullName, email, mobile, brithDate, password;
    private long regDate;



    public UserModel(int id, String fullName, String email, String mobile, String brithDate, String password, long regDate ) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.mobile = mobile;
        this.brithDate = brithDate;
        this.password = password;
        this.regDate = regDate;
    }

    public UserModel(int id, String fullName, String email, String mobile, String brithDate, String password ) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.mobile = mobile;
        this.brithDate = brithDate;
        this.password = password;
    }

    public UserModel(String fullName, String email, String mobile, String brithDate, String password, long regDate) {
        this.fullName = fullName;
        this.email = email;
        this.mobile = mobile;
        this.brithDate = brithDate;
        this.password = password;
        this.regDate = regDate;
    }

    public UserModel() {
    }



    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public long getRegDate() {
        return regDate;
    }

    public String getMobile() {
        return mobile;
    }

    public String getBrithDate() {
        return brithDate;
    }

    public String getPassword() {
        return password;
    }



    public void setRegDate(long regDate) {
        this.regDate = regDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setBrithDate(String brithDate) {
        this.brithDate = brithDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
