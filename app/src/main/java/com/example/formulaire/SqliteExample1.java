package com.example.formulaire;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

import com.example.formulaire.entity.Type;

import java.util.ArrayList;

public class SqliteExample1 extends ListActivity
{
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_example1);
        adapter=new Adapter(this);
        Cursor c=adapter.getAllTypeInCursor();
        int id=c.getInt(0);
        String libelle=c.getString(1);
        String[] columns = new String[] { id+"", libelle };
        int[] to = new int[] { R.id.name_entry, R.id.number_entry };

        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.listexample, c, columns, to);

        this.setListAdapter(mAdapter);

    }

}
