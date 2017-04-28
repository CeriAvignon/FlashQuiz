package ig.flash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class ImportActivity extends MainActivity {

    private Button NQ;
    private Button IQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import);


        NQ = (Button) findViewById(R.id.btn_new_quizz);
        IQ = (Button) findViewById(R.id.btn_import_quizz1);



        NQ.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                Intent myIntent = new Intent(ImportActivity.this, Createquizz.class);
                startActivity(myIntent);
            }

        });

        IQ.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                Intent myIntent = new Intent(ImportActivity.this, ImportQuizz2.class);
                startActivity(myIntent);
            }

        });
    }
}
