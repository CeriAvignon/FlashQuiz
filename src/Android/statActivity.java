package ig.flash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class statActivity extends MainActivity {
    /**
     * Called when the activity is first created.
     */
    Button stat1 = null;
    Button stat2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stat);

        //defini les bouttons dans le code
        stat1 = (Button) findViewById(R.id.stat1);
        stat2 = (Button) findViewById(R.id.stat2);
        //creation des listener
        stat1.setOnClickListener(stat1Listener);
        stat2.setOnClickListener(stat2Listener);
    }
        private OnClickListener stat1Listener= new OnClickListener() {
            @Override
            public void onClick(View v4) {
                Intent stat1 = new Intent(statActivity.this , stat1Activity.class);
                startActivity(stat1);
            }
        };

        // Listener du boutton stat 2
        private OnClickListener stat2Listener = new OnClickListener() {
            public void onClick(View v5) {
                Intent stat2 = new Intent(statActivity.this, stat2Activity.class);
                startActivity(stat2);
            }
        };
    }
