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
import android.widget.TextView;
//import model.base.*;    // importe les modèles de base
//import model.session.*;

import static  ig.flash.R.id.checkBox_mdp;
import static  ig.flash.R.id.checkBox_time;
import static  ig.flash.R.id.editText2;
import static  ig.flash.R.id.editText3;
import static  ig.flash.R.id.textView;

public class Createquizz extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createquizz);
    }


    public void affichage_PopUp_mdp(View v)
    {
        CheckBox checkboxmdp = (CheckBox) findViewById(checkBox_mdp);
        if(checkboxmdp.isChecked())
        {
            ShowMotDePasse();
        }
    }

    public void affichage_PopUp_time(View v)
    {
        CheckBox checkboxtime = (CheckBox) findViewById(checkBox_time);
        if(checkboxtime.isChecked())
        {
            ShowTime();
        }
    }
    EditText first;
    EditText second;
    String mdp;
    CheckBox checkboxmdp;
    private void ShowMotDePasse() {
        checkboxmdp = (CheckBox) findViewById(checkBox_mdp);
        final AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        View mdplayout = inflater.inflate(R.layout.popupmotdepasse, null);
        first = (EditText)mdplayout.findViewById(R.id.editText2);
        second = (EditText)mdplayout.findViewById(editText3);
        helpBuilder.setView(mdplayout);
        helpBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        if(first.getText().toString().equals("") || second.getText().toString().equals("") || !first.getText().toString().equals(second.getText().toString())){
                            checkboxmdp.setChecked(false);
                        }
                        else{
                            mdp=first.getText().toString();
                            TextView text=(TextView) findViewById(textView);
                            text.setText(mdp);
                        }
                    }
                });
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
        Button ok =helpDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        ok.setTextColor(Color.BLUE);
    }

    private void ShowTime() {
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        View timelayout = inflater.inflate(R.layout.popupminuteur, null);
        helpBuilder.setView(timelayout);

        helpBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                    }
                });
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
        Button ok =helpDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        ok.setTextColor(Color.BLUE);
    }

    public void modif_questionnaire(View view) {

        startActivity(new Intent(this,Modifquizz.class));
    }
}
