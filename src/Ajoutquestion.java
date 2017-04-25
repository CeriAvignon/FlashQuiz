package ceri.createquizz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;


public class Ajoutquestion extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajoutquestion);
    }

    /*public void textevisible(View v){

        RadioButton texte =(RadioButton) findViewById(R.id.radioButton2);
        texte.setVisibility(View.VISIBLE); //show textview
    }

    public void texteinvisible(View v){

        RadioButton texte =(RadioButton) findViewById(R.id.radioButton2);
        texte.setVisibility(View.INVISIBLE);
    }*/
    public void Select_reponse(View view)
    {
        RadioButton checkbox = (RadioButton) findViewById(R.id.radioButton);
        RadioButton radio = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton texte = (RadioButton) findViewById(R.id.radioButton2);
        if(checkbox.isChecked())
        {
            startActivity(new Intent(this,Selectcheckbox.class));
        }
        if(radio.isChecked())
        {
            startActivity(new Intent(this,Selectradio.class));
        }
        if(texte.isChecked())
        {
            startActivity(new Intent(this,Selecttext.class));
        }
    }
}
