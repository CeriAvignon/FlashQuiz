package ig.flash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Donnee;
    private TextView Donnee2;
    private Button suivant;
    public String nsession="1";
    public String Sujet="Henry IV";
    public String nbquestion="4";
    public String temps="infini";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Donnee = (TextView) findViewById(R.id.NomSession);
        Donnee.setText("Session"+nsession+":"+Sujet);
        Donnee2 = (TextView) findViewById(R.id.NbQuestion);
        Donnee2.setText("Il y aura :"+nbquestion+" questions et un temps:"+temps+" pour y répondre.");
        suivant = (Button) findViewById(R.id.start);

        suivant.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent myIntent = new Intent(MainActivity.this, StartSession.class);
                startActivity(myIntent);
            }

        });
    }
}
