package com.example.formulaire.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.formulaire.table.TableType;

class MySQLiteHelper extends SQLiteOpenHelper
{

    private static final String DB_NAME = "test.db";
    private static final int DB_VERSION = 1;

    public MySQLiteHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase bdd)
    {
        TableType.create(bdd);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bdd, int oldVersion, int newVersion) {
        TableType.drop(bdd);
        onCreate(bdd);
    }
}
