package com.fquiz.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class ImportActivity extends AppCompatActivity {
    Switch switch_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import);

        switch_logout = (Switch) findViewById(R.id.switch_logout);

        //redirection vers la page d'accueil
        switch_logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                    Intent myIntent = new Intent(ImportActivity.this, loginActivity.class);
                    startActivity(myIntent);
                }

        });
    }
}
