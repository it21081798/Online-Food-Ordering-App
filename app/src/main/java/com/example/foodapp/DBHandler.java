
package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "Instania.db";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String DbEntries =
                "CREATE TABLE " +UserTable.Users.USER_TABLE_NAME+ " (" +
                        UserTable.Users.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        UserTable.Users.COLUMN_FULL_NAME + " TEXT," +
                        UserTable.Users.COLUMN_EMAIL + " TEXT,"  +
                        UserTable.Users.COLUMN_BIRTHDATE + " DATE," +
                        UserTable.Users.COLUMN_MOBILE + " INTEGER, " +
                        UserTable.Users.COLUMN_PASSWORD + " TEXT, " +
                        UserTable.Users.COLUMN_REG_DATE + " )";

        sqLiteDatabase.execSQL(DbEntries);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean registerUser(UserModel userModel){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UserTable.Users.COLUMN_FULL_NAME, userModel.getFullName());
        contentValues.put(UserTable.Users.COLUMN_EMAIL, userModel.getEmail());
        contentValues.put(UserTable.Users.COLUMN_MOBILE, userModel.getMobile());
        contentValues.put(UserTable.Users.COLUMN_MOBILE, userModel.getMobile());
        contentValues.put(UserTable.Users.COLUMN_BIRTHDATE, userModel.getBrithDate());
        contentValues.put(UserTable.Users.COLUMN_REG_DATE, userModel.getRegDate());
        contentValues.put(UserTable.Users.COLUMN_PASSWORD, userModel.getPassword());

        long result = sqLiteDatabase.insert(UserTable.Users.USER_TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();

        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean checkUsername(String username){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Users where "+UserTable.Users.COLUMN_EMAIL+" = ?", new String[] {username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean login(String username, String password){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Users where Email = ? and Password = ?", new String[] {username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

}

