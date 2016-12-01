package com.example.flashquizz;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;


public class acceuilActivity extends Activity{

Button newQuizz=null;
Button participQuizz=null;
Button stat=null;
Button reglage=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceuil);
        
        
    //defini les bouttons dans le code     
        newQuizz= (Button)findViewById(R.id.newQuizz);
        participQuizz= (Button)findViewById(R.id.participQuizz);
        stat= (Button)findViewById(R.id.stat);
        reglage= (Button)findViewById(R.id.reglage);
    //creation des listener
        newQuizz.setOnClickListener(newQuizzListener);
        participQuizz.setOnClickListener(participQuizzListener);
        stat.setOnClickListener(statListener);
        reglage.setOnClickListener(reglageListener);
    }
    
    // Listener du boutton créer un quizz
    private OnClickListener newQuizzListener = new OnClickListener() {
        @Override
        public void onClick(View v1) {
        	Intent newquizz = new Intent(acceuilActivity.this, nouveauquizzActivity.class);
        	startActivity(newquizz);
        }
      };
      
      // Listener du boutton parcitiper a un quizz
     private OnClickListener participQuizzListener = new OnClickListener() {
          @Override
          public void onClick(View v2) {
          	Intent participquizz = new Intent(acceuilActivity.this, participQuizzActivity.class);
          	startActivity(participquizz);
          }
        };
        
        // Listener du boutton statistique
     private OnClickListener statListener = new OnClickListener() {
            @Override
            public void onClick(View v3) {
              	Intent statquizz = new Intent(acceuilActivity.this, statActivity.class);
              	startActivity(statquizz);
            }
          };  
          
          // Listener du boutton reglage
     private OnClickListener reglageListener = new OnClickListener() {
              @Override
              public void onClick(View v4) {
                Intent reglagequizz = new Intent(acceuilActivity.this, reglageActivity.class);
                startActivity(reglagequizz);
              }
            };

}
