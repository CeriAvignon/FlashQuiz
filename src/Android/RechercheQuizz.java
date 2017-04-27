package ig.flash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RechercheQuizz extends MainActivity {
    private EditText Donnee;
    public int compteurX=0;
    private TextView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche_quizz);
        Donnee = (EditText) findViewById(R.id.Recherche);

        test = (TextView) findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent myIntent = new Intent(RechercheQuizz.this, MainActivity.class);
                startActivity(myIntent);
            }

        });

    }

}