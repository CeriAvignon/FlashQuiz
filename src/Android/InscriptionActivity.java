package ig.flash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InscriptionActivity extends MainActivity {
    private EditText login;
    private EditText PWD;
    private EditText eMail;
    private Button vlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        login = (EditText) findViewById(R.id.editText_login);
        PWD = (EditText) findViewById(R.id.editTextpassword);
        eMail = (EditText) findViewById(R.id.editText_email);
        vlogin = (Button) findViewById(R.id.button_inscrire);

       vlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                Intent myIntent = new Intent(InscriptionActivity.this, loginActivity.class);
                startActivity(myIntent);
            }

        });
    }
}
