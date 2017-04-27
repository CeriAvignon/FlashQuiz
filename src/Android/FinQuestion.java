package ig.flash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class FinQuestion extends StartSession {
    private ProgressBar T;
    private TextView Q;
    private TextView QBR;
    private TextView QMR;
    private TextView nb_res;
    private Button suivant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fin_question);
        T = (ProgressBar) findViewById(R.id.time);
        Q = (TextView)findViewById(R.id.Question);
        Q.setText(question.getText());
        QBR = (TextView)findViewById(R.id.PourcentageT1);
        QMR = (TextView)findViewById(R.id.PourcentageT2);
        nb_res = (TextView)findViewById(R.id.nb_restant);
        suivant = (Button) findViewById(R.id.Recap);

        if(compteurX < 5) {
            suivant.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(FinQuestion.this, StartSession.class);
                    startActivity(myIntent);
                }

            });
        }else {
            suivant.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(FinQuestion.this, RecapAll.class);
                    startActivity(myIntent);
                }

            });
        }

    }
}