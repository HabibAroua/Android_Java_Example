package com.example.formulaire;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity {
    Button firstFragment, secondFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
// get the reference of Button's
        firstFragment = (Button) findViewById(R.id.firstFragment);
        secondFragment = (Button) findViewById(R.id.secondFragment);
// perform setOnClickListener event on First Button
        firstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // load First Fragment
                loadFragment(new Fragement_First());
            }
        });
// perform setOnClickListener event on Second Button
        secondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// load Second Fragment
                loadFragment(new Secand_Fragment());
            }
        });
    }
    private void loadFragment(Fragment fragment)
    {
        FragmentManager fm = getFragmentManager();

        FragmentTransaction fragmentTransaction =
                fm.beginTransaction();


        fragmentTransaction.replace(R.id.frameLayout,
                fragment);
// save the changes
        fragmentTransaction.commit(); }
}
