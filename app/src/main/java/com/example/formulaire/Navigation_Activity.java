package com.example.formulaire;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Navigation_Activity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
{
    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.navigation_home:
                mTextMessage.setText("home");
                return true;
            case R.id.navigation_dashboard:
                mTextMessage.setText("dashboard");
                return true;
            case R.id.navigation_notifications:
                mTextMessage.setText("notification");
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.navigation , menu);
        return true;
    }

   // @Override
    public boolean onOptionsItemSelectedMenuItem(MenuItem item)
    {
        int id = item.getItemId();

     //   if(id==R.id.action_settings)
        {
       //     mTextMessage.setText(R.string.settings);
         //   return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
