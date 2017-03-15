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
    public void modif_texte(View v)
    {
        switch (v.getId())
        {
            case (R.id.button5):
                changetexte(5);
            case (R.id.button6):
                changetexte(6);
            case (R.id.button7):
                changetexte(7);
            case (R.id.button8):
                changetexte(8);
        }
    }
    EditText texte;
    int button;
    RadioButton choix1;
    RadioButton choix2;
    RadioButton choix3;
    RadioButton choix4;
    public void changetexte(int i) {
        button = i;
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        View modiflayout = inflater.inflate(R.layout.popupmodif, null);
        helpBuilder.setView(modiflayout);
        texte = (EditText) findViewById (R.id.editText4);
        choix1 = (RadioButton) findViewById(R.id.radioButton4);
        choix2 = (RadioButton) findViewById(R.id.radioButton5);
        choix3 = (RadioButton) findViewById(R.id.radioButton6);
        choix4 = (RadioButton) findViewById(R.id.radioButton7);
        helpBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        if(button==5)
                        {
                            choix1.setText(texte.getText());
                        }
                        if(button==6)
                        {
                            choix2.setText(texte.getText());
                        }
                        if(button==7)
                        {
                            choix3.setText(texte.getText());
                        }
                        if(button==8)
                        {
                            choix4.setText(texte.getText());
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
