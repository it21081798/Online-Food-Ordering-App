
package com.example.foodapp;

import android.provider.BaseColumns;

public final class UserTable {
    private UserTable(){};

    public static class Users implements BaseColumns{
        public static final String TABLE_NAME = "Users";
        public static final String COLUMN_FULL_NAME = "FullName";
        public static final String COLUMN_Email = "Email";
        public static final String COLUMN_Mobile = "Mobile";
        public static final String COLUMN_BirthDate = "BirthDate";
        public static final String COLUMN_Password = "Password";
    }
}

