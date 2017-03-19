package com.fquiz.loginapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {
/* ------------------------------------- */
//Declaration EditText
    private EditText editText_email;

    //Envoyer button
    private Button btn_envoyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initializing the views
        editText_email = (EditText) findViewById(R.id.editText_email);

        btn_envoyer = (Button) findViewById(R.id.btn_envoyer);

        //Adding click listener
        btn_envoyer.setOnClickListener(this);
    }


    private void sendEmail() {
        //Getting content for email
        String email = editText_email.getText().toString().trim();
        String subject = " Mot de passe oublié ";
        String message = " Voici le mot de passe par défault: passer  ";

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }
}
