package com.example.formulaire;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.formulaire.entity.*;

import java.util.ArrayList;

public class ActivityOfListView extends ListActivity
{

    final Etudiant[] data=
            {
                    new Etudiant(10 ,"Zeinab"),
                    new Etudiant(13,"Yassine"),
                    new Etudiant(20,"Youssef")

            };
    ArrayList<Etudiant>eListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_of_list_view);
        eListe=new ArrayList<>();
        for(Etudiant etudiant : data)
        {
            eListe.add(etudiant);
        }

        ArrayAdapter<Etudiant> adapter= new ArrayAdapter<Etudiant>
                (
                        this ,
                        android.R.layout.simple_list_item_1,
                        eListe
                );
        setListAdapter(adapter);

    }
}
