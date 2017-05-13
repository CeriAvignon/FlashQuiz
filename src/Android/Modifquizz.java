package ig.flash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ig.flash.Createquizz;
import ig.flash.ImportActivity;


public class Modifquizz extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifquizz);
    }
   public void validerquestionnaire(View view){
        startActivity(new Intent(this,acceuilActivity.class));
    }
    public void ajout_question(View view) {

        startActivity(new Intent(this,Ajoutquestion.class));
    }
}
