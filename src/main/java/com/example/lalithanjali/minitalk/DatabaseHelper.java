package com.example.lalithanjali.minitalk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Register.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table UserDetails(Email text,Username text primary key,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists UserDetails");
    }

    public boolean insert(String email,String username,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("username",username);
        contentValues.put("password",password);
        long ins = db.insert("UserDetails",null,contentValues);
        if(ins == -1)
            return false;
        else
            return true;
    }

    public Boolean checkemail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from UserDetails where email=?",new String[]{email});
        if(cursor.getCount() > 0)
            return false;
        else
            return true;
    }

    public Boolean checkuser(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from UserDetails where username=?",new String[]{username});
        if(cursor.getCount() > 0)
            return false;
        else
            return true;
    }
}
