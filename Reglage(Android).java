package ceri.flashquizz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class Reglage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reglage);

        Button ButtonLanguage = (Button) findViewById(R.id.Language);
        ButtonLanguage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ShowLanguage();
            }
        });
        Button ButtonColor = (Button) findViewById(R.id.Couleur);
        ButtonColor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ShowColor();
            }
        });
    }

    private void ShowLanguage() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("Langue");
        helpBuilder.setMessage("Choisissez la langue:");

        LayoutInflater inflater = getLayoutInflater();
        View languagelayout = inflater.inflate(R.layout.popuplanguagelayout, null);
        helpBuilder.setView(languagelayout);

        helpBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                    }
                });

        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }
    private void ShowColor() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("Couleur");
        helpBuilder.setMessage("Choisissez la couleur:");

        LayoutInflater inflater = getLayoutInflater();
        View colorlayout = inflater.inflate(R.layout.popupcolorlayout, null);
        helpBuilder.setView(colorlayout);

        helpBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                    }
                });

        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }
}
