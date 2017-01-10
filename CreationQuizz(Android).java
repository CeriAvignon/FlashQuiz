package ceri.createquizz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import static ceri.createquizz.R.id.checkBox_mdp;

public class Createquizz extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createquizz);
    }


    public void affichage_PopUp(View v)
    {
        CheckBox checkboxmdp = (CheckBox) findViewById(checkBox_mdp);
        if(checkboxmdp.isChecked())
        {
            ShowMotDePasse();
        }
    }
    private void ShowMotDePasse() {
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        View mdplayout = inflater.inflate(R.layout.popupmotdepasse, null);
        helpBuilder.setView(mdplayout);

        helpBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                    }
                });

        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
        Button ok =helpDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        ok.setTextColor(Color.BLUE);
    }
}
