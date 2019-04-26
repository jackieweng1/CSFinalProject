package com.example.csfinalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class firstblock extends BaseActivity {

    public int pointcount(int index) {
        if (index >= 0 && index <= 3) {
            return 1;
        } else if (index >= 4 && index <= 6) {
            return 2;
        } else if (index >= 7 && index <= 9) {
            return 3;
        } else {
            return 4;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstblock);
        Toolbar toolbar = findViewById(R.id.toolbar);

        try {
            CounterClass counterClass = CounterClass.getInstance();
            Log.i("TAG 222", counterClass.getFormatedTime());
        } catch (Exception e) {
            e.printStackTrace();
            // counter class is not initiated , access initInstance
        }

        final CounterClass counterClass = CounterClass.initInstance(30000, 1000);
        counterClass.start();
        final TextView pointtotal = (TextView)findViewById(R.id.Timer);
        //final String points2 = "Points: " + Double.toString(points);
        pointtotal.setText("Points " + Double.toString(points));

        final EditText edit = (EditText)findViewById(R.id.edit);
        final ImageView b4 = (ImageView)findViewById(R.id.block4);
        final ImageView b5 = (ImageView)findViewById(R.id.block5);
        final ImageView b6 = (ImageView)findViewById(R.id.block6);
        final ImageView b7 = (ImageView)findViewById(R.id.block7);
        final ImageView b8 = (ImageView)findViewById(R.id.block8);
        final ImageView b9 = (ImageView)findViewById(R.id.block9);
        final ImageView b10 = (ImageView)findViewById(R.id.block10);
        final ImageView b12 = (ImageView)findViewById(R.id.block12);
        final ImageView b12s = (ImageView)findViewById(R.id.block12s);
        final ImageView b16 = (ImageView)findViewById(R.id.block16);
        final ImageView b16s = (ImageView)findViewById(R.id.block16s);

        final ImageView[] blocks = new ImageView[] {b4, b5, b6, b7, b8, b9, b10, b12, b12s, b16, b16s, b16s};
        //final int[] block = {R.drawable.fourblock, R.drawable.fiveblock, R.drawable.sixblock, R.drawable.sevenblock, R.drawable.eightblock,
            //R.drawable.nineblock, R.drawable.tenblock, R.drawable.twelveblock, R.drawable.twelveblocksss, R.drawable.sixteenblocksss, R.drawable.sixteenblock};
        final String[] answer = {"4", "5", "6", "7", "8", "9", "10", "12", "12", "16", "16", "16"};
        final Button submit = (Button)findViewById(R.id.button4);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add error if empty
                final String value = edit.getText().toString();
                //points = 0;
                //set image using an imageview
                if (value.equals("")) {
                    edit.setError("Please enter the number of blocks.");
                } else if (value.equals(answer[blockcount])) {
                    blocks[blockcount].setVisibility(View.INVISIBLE);
                    blocks[blockcount + 1].setVisibility(View.VISIBLE);
                    points += pointcount(blockcount);
                    blockcount++;
                    edit.setText("");
                    pointtotal.setText("Points: " + String.valueOf(points));
                } else if (!(value.equals("")) && !(value.equals(answer[blockcount]))){
                    blocks[blockcount].setVisibility(View.INVISIBLE);
                    blocks[blockcount + 1].setVisibility(View.VISIBLE);
                    edit.setError("Incorrect! You lost points!");
                    points -= pointcount(blockcount);
                    blockcount++;
                    edit.setText("");
                    pointtotal.setText("Points: " + String.valueOf(points));
                }
                if (blockcount == 11){
                    startActivity(new Intent(firstblock.this, math.class));
                }
            }
            });



        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void secondblock(View view) {
        Intent spatial = new Intent(this, spatialActivity.class);
        startActivity(spatial);
    }
}
