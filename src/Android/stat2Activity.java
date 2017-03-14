package com.example.yoan.flashquizz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TableLayout;
import android.widget.TableRow;



public class stat2Activity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stat2);

        // données du tableau
        final String[] col1 = {"Stat 1", "Stat 2", "Stat 3", "Stat 4", "Stat 5"};
        final String[] col2 = {"10%", "20%", "95%", "65%", "2%"};
        TableLayout table = (TableLayout) findViewById(R.id.idTable);
        TableRow row;
        TextView cel1, cel2; // création des cellules

// Boucle qui fait chaque ligne
        for (int i = 0; i < col1.length; i++) {
            row = new TableRow(this);

            cel1 = new TextView(this);
            cel1.setText(col1[i]);
            cel1.setGravity(Gravity.CENTER);
            cel1.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));


            cel2 = new TextView(this);
            cel2.setText(col2[i]);
            cel2.setGravity(Gravity.CENTER);
            cel2.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));

            row.addView(cel1);
            row.addView(cel2);
            table.addView(row);
        }
    }
}
