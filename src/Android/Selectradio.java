package ig.flash;

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

import static ig.flash.R.id.button4;
import static ig.flash.R.id.checkBox_mdp;
import static ig.flash.R.id.checkBox_time;

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
                changetexte(1);
                break;
            case (R.id.button6):
                changetexte(2);
                break;
            case (R.id.button7):
                changetexte(3);
                break;
            case (R.id.button8):
                changetexte(4);
                break;
            case (R.id.button9):
                changetexte(5);
                break;
            case (R.id.button10):
                changetexte(6);
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
                            choix = (RadioButton) findViewById(R.id.radioButton4);
                            choix.setText(reponse);
                        }
                        if (rep==2)
                        {
                            choix = (RadioButton) findViewById(R.id.radioButton5);
                            choix.setText(reponse);
                        }
                        if (rep==3)
                        {
                            choix = (RadioButton) findViewById(R.id.radioButton6);
                            choix.setText(reponse);
                        }
                        if (rep==4)
                        {
                            choix = (RadioButton) findViewById(R.id.radioButton7);
                            choix.setText(reponse);
                        }
                        if (rep==5)
                        {
                            choix = (RadioButton) findViewById(R.id.radioButton8);
                            choix.setText(reponse);
                        }
                        if (rep==6)
                        {
                            choix = (RadioButton) findViewById(R.id.radioButton9);
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

    int i=0;
    public void textevisible(View v){
        switch (i)
        {
            case (0):
                RadioButton show = (RadioButton) findViewById(R.id.radioButton6);
                Button show2 = (Button) findViewById(R.id.button7);
                show.setVisibility(View.VISIBLE); //show
                show2.setVisibility(View.VISIBLE); //show
                i++;
                break;
            case (1):
                RadioButton show3 = (RadioButton) findViewById(R.id.radioButton7);
                Button show4 = (Button) findViewById(R.id.button8);
                show3.setVisibility(View.VISIBLE); //show
                show4.setVisibility(View.VISIBLE); //show
                i++;
                break;
            case (2):
                RadioButton show5 = (RadioButton) findViewById(R.id.radioButton8);
                Button show6 = (Button) findViewById(R.id.button9);
                show5.setVisibility(View.VISIBLE); //show
                show6.setVisibility(View.VISIBLE); //show
                i++;
                break;
            case (3):
                RadioButton show7 = (RadioButton) findViewById(R.id.radioButton9);
                Button show8 = (Button) findViewById(R.id.button10);
                show7.setVisibility(View.VISIBLE); //show
                show8.setVisibility(View.VISIBLE); //show
                break;
        }
    }

    public void texteinvisible(View v){
        switch (i)
        {
            case (0):
                RadioButton show = (RadioButton) findViewById(R.id.radioButton6);
                Button show2 = (Button) findViewById(R.id.button7);
                show.setVisibility(View.INVISIBLE); //show
                show2.setVisibility(View.INVISIBLE); //show
                break;
            case (1):
                RadioButton show3 = (RadioButton) findViewById(R.id.radioButton7);
                Button show4 = (Button) findViewById(R.id.button8);
                show3.setVisibility(View.INVISIBLE); //show
                show4.setVisibility(View.INVISIBLE); //show
                i--;
                break;
            case (2):
                RadioButton show5 = (RadioButton) findViewById(R.id.radioButton8);
                Button show6 = (Button) findViewById(R.id.button9);
                show5.setVisibility(View.INVISIBLE); //show
                show6.setVisibility(View.INVISIBLE); //show
                i--;
                break;
            case (3):
                RadioButton show7 = (RadioButton) findViewById(R.id.radioButton9);
                Button show8 = (Button) findViewById(R.id.button10);
                show7.setVisibility(View.INVISIBLE); //show
                show8.setVisibility(View.INVISIBLE); //show
                i--;
                break;
        }
    }

    public void modif_questionnaire(View view) {

        startActivity(new Intent(this,Modifquizz.class));
    }
}
