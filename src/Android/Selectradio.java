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
import android.widget.RadioButton;

import static ceri.createquizz.R.id.button4;
import static ceri.createquizz.R.id.checkBox_mdp;
import static ceri.createquizz.R.id.checkBox_time;

public class Selectradio extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectradio);
    }
    int rep;
    String reponse;
    EditText texte;
    RadioButton choix;
    public void modif_texte(View v)
    {

        switch (v.getId())
        {
            case (R.id.button5):
                changetexte(5);
                break;
            case (R.id.button6):
                changetexte(6);
                break;
            case (R.id.button7):
                changetexte(7);
                break;
            case (R.id.button8):
                changetexte(8);
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
                        if (rep==5)
                        {
                            choix = (RadioButton) findViewById(R.id.radioButton4);
                            choix.setText(reponse);
                        }
                        if (rep==6)
                        {
                            choix = (RadioButton) findViewById(R.id.radioButton5);
                            choix.setText(reponse);
                        }
                        if (rep==7)
                        {
                            choix = (RadioButton) findViewById(R.id.radioButton6);
                            choix.setText(reponse);
                        }
                        if (rep==8)
                        {
                            choix = (RadioButton) findViewById(R.id.radioButton7);
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
}
