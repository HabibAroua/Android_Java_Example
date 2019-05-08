package com.example.formulaire;

import android.app.ListActivity;
import android.content.res.Resources;
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
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_of_list_view);
        eListe=new ArrayList<>();
        getElementFromXmlFile();
    }

    private void getElementFromArrayList()
    {
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

    private void getElementFromXmlFile()
    {
        Resources res =getResources();
        final int[] numeros=res.getIntArray(R.array.numeros);
        final String noms[]=res.getStringArray(R.array.noms);

        for(int i=0 ; i<noms.length ; i++)
        {
            eListe.add(new Etudiant(numeros[i],noms[i]));
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