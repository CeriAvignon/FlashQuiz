package ig.flash;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;


public class stat1Activity extends MainActivity {
    public int variable1 = 55;
    public int variable2 = 45;
    public int variable3 = 10;
    public int variable4 = 20;
    public int variable5 = 95;

    private static String TAG = "PieChart";
    private float[] yData = {variable1, variable2};
    private String[] xData = {"bonne", "mauvaise"};
    PieChart pieChart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stat1);
        Log.d(TAG, "onCreate: ");
        pieChart = (PieChart) findViewById(R.id.idPiechart);

        pieChart.setUsePercentValues(true);
        pieChart.setCenterText("Stat");
        pieChart.setCenterTextSize(15);
        pieChart.setHoleRadius(40f);
        pieChart.setRotationEnabled(true);

        addDataSet(pieChart);

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Log.d(TAG, "onValueSelected: Value select from chart.");
                Log.d(TAG, "onValueSelected: " + e.toString());
                Log.d(TAG, "onValueSelected: " + h.toString());

            }

            @Override
            public void onNothingSelected() {

            }
        });

        // données du tableau
        final String[] col1 = {"Stat 1", "Stat 2", "Stat 3", "Stat 4", "Stat 5"};
        final float[] col2 = {variable3, variable4, variable5, variable5, variable5};
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
            cel2.setText(String.valueOf(col2[i]));
            cel2.setGravity(Gravity.CENTER);
            cel2.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));

            row.addView(cel1);
            row.addView(cel2);
            table.addView(row);
        }
    }


    private void addDataSet(PieChart piechart) {
        Log.d(TAG, "addDataSet: started");
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for (int i = 0; i < yData.length; i++) {
            yEntrys.add(new PieEntry(yData[i], i));
        }

        for (int i = 1; i < xData.length; i++) {
            xEntrys.add(xData[i]);
        }

        //crée les données
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "reponses");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        //ajout des couleurs
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        pieDataSet.setColors(colors);

        //ajout de la légende
        //Legend legend = pieChart.getLegend();
        //legend.setForm(Legend.LegendForm.CIRCLE);
        //legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //crée l'objet pieData
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}
