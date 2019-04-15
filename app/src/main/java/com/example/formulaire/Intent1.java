package com.example.formulaire;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intent1 extends AppCompatActivity
{
    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent1);
        bt1=(Button)findViewById(R.id.btAppel);         //Appel telephone
        bt2=(Button)findViewById(R.id.btWeb);           //ouvrir une page web
        bt3=(Button)findViewById(R.id.btMail);          //envoyer un mail
        bt4=(Button)findViewById(R.id.btMap);           //ouvrir une street map
        bt5=(Button)findViewById(R.id.btMapLatLong);    // ouvir une map geographique en utilisatant latitude et longiture
        bt6=(Button)findViewById(R.id.btMapQuary);      //chercher une position dans une map en utilisant une requ$ette de recherche
        bt7=(Button)findViewById(R.id.btMapRestuarant); //
        bt8=(Button)findViewById(R.id.btMapHotel);
        bt9=(Button)findViewById(R.id.btMapCiteCulture);
        bt10=(Button)findViewById(R.id.btMapCiteCultureHotel);

        bt1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Uri number =Uri.parse("tel:+21626053091");
                Intent callIntent=new Intent(Intent.ACTION_DIAL,number);
                startActivity(callIntent);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri webpage=Uri.parse("https://universitesesame.com/");
                Intent webIntent=new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(webIntent);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent emailIntent=new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[] {"hatem.aziza@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Email message text");
                emailIntent.putExtra(Intent.EXTRA_TEXT ,"Email message text");
                emailIntent.putExtra(Intent.EXTRA_STREAM,Uri.parse("content://path/attachement"));
                startActivity(emailIntent);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Uri gmmIntentUri =Uri.parse("google.streetview:cbl1=46.414382,10.013988");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if(mapIntent.resolveActivity((getPackageManager()))!=null)
                {
                    startActivity(mapIntent);
                }

            }
        });

        bt5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri location=Uri.parse("geo:36.898242,10.192328");
                Intent mapIntent=new Intent(Intent.ACTION_VIEW,location);
                mapIntent.setPackage("com.google.android.apps.maps");
                if(mapIntent.resolveActivity((getPackageManager()))!=null)
                {
                    startActivity(mapIntent);
                }
            }
        });

        bt6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri location=Uri.parse("geo:0, 0?q=Université+SESAME,+ZI+Chotrana");
                Intent mapIntent=new Intent(Intent.ACTION_VIEW,location);
                mapIntent.setPackage("com.google.android.apps.maps");
                if(mapIntent.resolveActivity((getPackageManager()))!=null)
                {
                    startActivity(mapIntent);
                }
            }
        });

        bt7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri gmmIntentUri=Uri.parse("geo:0,0?q=resturants");
                Intent mapIntent=new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        bt8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri gmmIntentUri=Uri.parse("geo:37.7749,-122.4194?q=hotels");
                Intent mapIntent=new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        //Si vous préfrez ne pas payer de péage ni prendre ni prendre ni prendre un ferry
        //
        bt9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri gmmIntentUri=Uri.parse("google.navigation:q=36.811867, 10.185986&void=tf");
                Intent mapIntent=new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        //Demander des indicateurs pour les cyclistes
        bt10.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri gmmIntentUri=Uri.parse("google.navigation:q=36.811867 , 10.185986&mode=b");
                Intent mapIntent=new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
