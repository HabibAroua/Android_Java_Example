package com.example.formulaire;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SqliteExample1 extends AppCompatActivity
{
    SQLiteDatabase bdd;
    MySqliteHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_example1);
        helper=new MySqliteHelper(this);
        bdd
    }
}
