package com.example.formulaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity
{
    Button bt;
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bt=(Button)findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final String val=bt.getText().toString();
                i=Integer.parseInt(val);
                i++;
                bt.setText(""+i);
            }
        });
    }


    @Override
    protected  void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        Toast.makeText(getApplicationContext(),"Now onSaveInstanceState calls", Toast.LENGTH_LONG).show(); //onSaveInstanceState Called
    }

    @Override
    protected  void onRestoreInstanceState (Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(),"Now onRestoreInstanceState calls", Toast.LENGTH_LONG).show(); //onRestoreInstanceState Called
    }



}