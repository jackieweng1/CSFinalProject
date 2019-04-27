package com.example.csfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ranking extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView caption = findViewById(R.id.caption);
        ImageView image = (ImageView)findViewById(R.id.turd);
        TextView pointtotal = (TextView)findViewById(R.id.textView7);
        pointtotal.setText("Points " + Double.toString(points));
        Button home = (Button)findViewById(R.id.restart);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ranking.this, MainActivity.class));
            }
        });
        if (points <= 0) {
            image.setImageResource(R.drawable.turd);
            caption.setText("Congratulations, you are as inturdigent as a turd.");
        } else if (points > 0 && points <= 35) {
            image.setImageResource(R.drawable.patrick);
            caption.setText("You're as bright as a seastar! So, not very bright.");
        } else if (points > 35 && points <= 55) {
            image.setImageResource(R.drawable.chuchu);
            caption.setText("With this level of smarts, you may/may not have it ruff.");
        } else if (points > 55 && points < 70) {
            image.setImageResource(R.drawable.dexter);
            caption.setText("What a nerddddd.");
        } else {
            image.setImageResource(R.drawable.einstein);
            caption.setText("Two things are infinite; the universe and human stupidity; but I'm not sure about you");
        }
    }
}
