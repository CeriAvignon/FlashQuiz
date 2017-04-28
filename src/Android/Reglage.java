package ig.flash;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class Reglage extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reglage);

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

        LayoutInflater inflater = getLayoutInflater();
        View languagelayout = inflater.inflate(R.layout.popuplanguage, null);
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
        Button ok =helpDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        ok.setTextColor(Color.BLUE);
    }
    private void ShowColor() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        View colorlayout = inflater.inflate(R.layout.popupcolor, null);
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
        Button ok =helpDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        ok.setTextColor(Color.BLUE);
    }
}