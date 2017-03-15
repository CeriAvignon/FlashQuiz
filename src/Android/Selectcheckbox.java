package ceri.createquizz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class Selectcheckbox extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectcheckbox);
    }
    int rep;
    String reponse;
    EditText texte;
    CheckBox choix;
    public void modif_texte(View v)
    {

        switch (v.getId())
        {
            case (R.id.button10):
                changetexte(1);
                break;
            case (R.id.button11):
                changetexte(2);
                break;
            case (R.id.button12):
                changetexte(3);
                break;
            case (R.id.button13):
                changetexte(4);
                break;
        }
    }

    public void changetexte(int i) {
        rep=i;
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View modiflayout = inflater.inflate(R.layout.popupmodif, null);
        helpBuilder.setView(modiflayout);
        texte = (EditText)modiflayout.findViewById (R.id.editText4);
        helpBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        reponse=texte.getText().toString().trim();
                        if (rep==1)
                        {
                            choix = (CheckBox) findViewById(R.id.checkBox);
                            choix.setText(reponse);
                        }
                        if (rep==2)
                        {
                            choix = (CheckBox) findViewById(R.id.checkBox2);
                            choix.setText(reponse);
                        }
                        if (rep==3)
                        {
                            choix = (CheckBox) findViewById(R.id.checkBox3);
                            choix.setText(reponse);
                        }
                        if (rep==4)
                        {
                            choix = (CheckBox) findViewById(R.id.checkBox4);
                            choix.setText(reponse);
                        }
                    }
                });

        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
        Button ok =helpDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        ok.setTextColor(Color.BLUE);
    }

    public void modif_questionnaire(View view) {

        startActivity(new Intent(this,Modifquizz.class));
    }
}
