package com.example.formulaire.table;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.formulaire.entity.Type;

public class TableType
{
    public static final String NomTable = "Types";
    public static final String Id = "_id";
    public static final String Libelle = "libelle";

    public static void create(SQLiteDatabase bdd)
    {
        bdd.execSQL("CREATE TABLE " + NomTable + "(" + Id + " INTEGER PRIMARY KEY AUTOINCREMENT," + Libelle + " TEXT NOT NULL)");
    }

    public static void drop(SQLiteDatabase bdd)
    {
        bdd.execSQL("DROP TABLE IF EXISTS " + NomTable);
    }

    public static void insertType(SQLiteDatabase bdd, Type type)
    {
        bdd.execSQL("INSERT INTO " + NomTable + " VALUES (null, ?)", new Object[]{type.getLibelle()});
    }

    public static void deleteType(SQLiteDatabase bdd, long id)
    {
        bdd.execSQL("DELETE FROM " + NomTable + " WHERE " + Id + "=?", new Object[]{id});
    }

    public static String getLibelle(SQLiteDatabase bdd, long id)
    {
        Cursor cursor = bdd.rawQuery("SELECT libelle FROM Types WHERE _id=?", new String[]{Long.toString(id)});
        try
        {
            if (cursor.moveToFirst() && !cursor.isNull(0))
            {
                return cursor.getString(0);
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println("Error : "+e.getMessage());
            return null;
        }
        finally
        {
            cursor.close();
        }
    }

    public static Cursor getAllTypes(SQLiteDatabase bdd)
    {
        return bdd.rawQuery("SELECT * FROM Types", null);
    }
}
