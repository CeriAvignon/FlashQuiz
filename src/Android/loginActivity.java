package com.fquiz.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    Button btn_login;
    EditText username,password;
    TextView link_inscription;
    TextView textView_forgot_pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btn_login = (Button) findViewById(R.id.btn_login);
        link_inscription = (TextView) findViewById(R.id.link_inscription);
        textView_forgot_pwd = (TextView) findViewById(R.id.textView_forgot_pwd);

        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("passer") ){
                    Toast.makeText(getApplicationContext(),"Login Success", Toast.LENGTH_LONG);
                    Intent myIntent = new Intent(loginActivity.this, ImportActivity.class);
                    startActivity(myIntent);
                }
            }
        });
        //Lien d'inscription
        link_inscription.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                    Intent myIntent = new Intent(loginActivity.this, InscriptionActivity.class);
                    startActivity(myIntent);
                }

        });
        //lien Mot de passe oublié
        textView_forgot_pwd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent myIntent = new Intent(loginActivity.this, ForgotPasswordActivity.class);
                startActivity(myIntent);
            }

        });


    }
}

