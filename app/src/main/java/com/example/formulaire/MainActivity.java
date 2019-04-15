package com.example.formulaire;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText txtTo,txtSubject,txtMessage;
    Button btSend;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTo=(EditText)findViewById(R.id.txtTo);
        txtSubject=(EditText)findViewById(R.id.txtSubject);
        txtMessage=(EditText)findViewById(R.id.txtMessage);
        btSend=(Button)findViewById(R.id.btSend);
        btSend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendEmail(txtTo.getText().toString(),txtSubject.getText().toString(),txtMessage.getText().toString());
            }
        });

    }

    private void sendEmail(String to , String subject , String message)
    {
        try
        {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            emailIntent.putExtra(Intent.EXTRA_TEXT, message);
            emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/attachement"));

            startActivity(emailIntent);
            Toast.makeText(MainActivity.this, "Mail Sent", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this, "Erro : "+e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }
}
