package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import SQLite.SQLiteHelper;

public class SQLiteDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_demo);
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this);
        final SQLiteDatabase database = sqLiteHelper.getReadableDatabase();
        database.close();
    }
}