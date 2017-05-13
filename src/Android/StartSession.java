package ig.flash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class StartSession extends RechercheQuizz {
    public TextView question;
    public TextView type;
    private EditText reponse;
    private Button valid;


    @Override
    protected void onCreate(Bundle savedInstanceState/*,Question q*/) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_session);
        question = (TextView)findViewById(R.id.NQuestion);

        type = (TextView)findViewById(R.id.type);
        valid = (Button) findViewById(R.id.Valider);

        valid.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent myIntent = new Intent(StartSession.this, FinQuestion.class);
                startActivity(myIntent);
            }

        });
        compteurX++;
        if(compteurX==1){
             question.setText("Quel est la couleur du cheval blanc d'Henry IV?");
             type.setText("Type:Texte libre");

        }

        if(compteurX==2){
            question.setText("Quel est la profession d'Henry IV?");
            type.setText("Type:Texte libre");

        }

        if(compteurX==3){
            question.setText("Quel etait son plat favori?");
            type.setText("Type:Texte libre");

        }

        if(compteurX==4){
            question.setText("Qui était le bras droit d'Henr IV");
            type.setText("Type:Texte libre");

        }




    }

    public EditText Reponse(){
        reponse =(EditText) findViewById(R.id.text);
        return reponse;
    }
}
