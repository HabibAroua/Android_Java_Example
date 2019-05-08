package com.example.formulaire;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.formulaire.entity.Type;

import java.util.ArrayList;

public class Adapter
{
    static final String DATABASE_NAME = "database.db";
    static final int DATABASE_VERSION = 1;
    public  static String getPassword="";
    public static final int NAME_COLUMN = 1;
    // TODO: Create public field for each column in your table.
    static final String DATABASE_CREATE = "create table Type( ID integer primary key autoincrement , LIBELLE  text); ";
    public static SQLiteDatabase db;
    private final Context context;
    private static DataBaseHelper dbHelper;
    public  Adapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public  Adapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();        return this;
    }

    public void close()
    {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }


    public ArrayList<Type> getAllType()
    {
        db=dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from Type",null);
        try
        {
            ArrayList<Type> list=new ArrayList<>();
            if(cursor.moveToFirst())
            {
                while(!cursor.isAfterLast())
                {
                    int id=cursor.getInt(0);
                    String libelle=cursor.getString(1);
                    list.add(new Type(id , libelle));
                    cursor.moveToNext();
                }
            }
            return list;
        }
        catch(Exception ex)
        {
            System.out.println("Error : "+ex.getMessage());
            return null;
        }
        finally
        {
            cursor.close();
        }
    }

    public Cursor getAllTypeInCursor()
    {
        db=dbHelper.getReadableDatabase();
        return db.rawQuery("Select * from Type",null);
    }
}
