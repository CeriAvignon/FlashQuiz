package ig.flash;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TableLayout;
import android.widget.TableRow;
import java.util.ArrayList;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.formatter.PercentFormatter;


public class stat2Activity extends MainActivity {
    public int variable1 = 85;
    public int variable2 = 65;
    public int variable3 = 10;
    public int variable4 = 20;
    public int variable5 = 95;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.stat2);

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

// barchart
        HorizontalBarChart chart = (HorizontalBarChart) findViewById(R.id.chart);
        chart.setContentDescription("");
        BarData data = new BarData(getDataSet());
        chart.setData(data);
        chart.animateXY(2000, 2000);
        chart.invalidate();

        YAxis left = chart.getAxisLeft();
        left.setDrawLabels(false); // no axis labels
        left.setDrawAxisLine(false); // no axis line
        left.setDrawGridLines(false); // no grid lines
        left.setDrawZeroLine(true); // draw a zero line
        chart.getAxisRight().setEnabled(false); // no right axis
        chart.setDrawValueAboveBar(false);


        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawLabels(false); // no axis labels
        xAxis.setDrawAxisLine(false); // no axis line
        xAxis.setDrawGridLines(false); // no grid lines
        chart.getXAxis().setEnabled(false);

    }

    private BarDataSet getDataSet() {

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, 0));
        entries.add(new BarEntry(1f, variable1));
        entries.add(new BarEntry(2f, variable2));



        BarDataSet dataSet = new BarDataSet(entries,"bonne reponses");
        dataSet.setDrawValues(true);
        dataSet.setValueFormatter(new PercentFormatter());
        return dataSet;
    }
/*
    private ArrayList<String> getXAxisValues() {
        ArrayList<String> labels = new ArrayList<>();
        labels.add("info1");
        return labels;
    }
*/
}








