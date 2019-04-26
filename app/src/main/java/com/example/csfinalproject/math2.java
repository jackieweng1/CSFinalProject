package com.example.csfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class math2 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math2);
        Toolbar toolbar = findViewById(R.id.toolbar);

        final TextView pointto = (TextView)findViewById(R.id.pointstext);
        //final String points2 = "Points: " + Double.toString(points);
        pointto.setText("Points " + Double.toString(points));

        blockcount = 0;
        final TextView instruction = (TextView)findViewById(R.id.instructions);
        //final String points2 = "Points: " + Double.toString(points);

        final EditText edit = (EditText)findViewById(R.id.edit);
        final ImageView q1 = (ImageView)findViewById(R.id.q1);
        final ImageView q2 = (ImageView)findViewById(R.id.q2);
        final ImageView q3 = (ImageView)findViewById(R.id.q3);
        final ImageView q4 = (ImageView)findViewById(R.id.q4);
        final ImageView q5 = (ImageView)findViewById(R.id.q5);

        final String[] instructionarray = {"Which answer is a reflection of the image shown", "Which box can be folded from the image shown?", "Which 3d figure can be folded from the image shown?", "Which box layout can fold into the image shown?", "Which box layout can fold into the image shown?"};

        final ImageView[] blocks = new ImageView[] {q1, q2, q3, q4, q5, q5};
        //final int[] block = {R.drawable.fourblock, R.drawable.fiveblock, R.drawable.sixblock, R.drawable.sevenblock, R.drawable.eightblock,
                //R.drawable.nineblock, R.drawable.tenblock, R.drawable.twelveblock, R.drawable.twelveblocksss, R.drawable.sixteenblocksss, R.drawable.sixteenblock};
        final String[] answer = {"C", "D", "E", "C", "B", "B"};
        final String wrong = "abcdefghijklmnopqrstuvwxyzFGHIJKLMNOPQRSTUVWXYZ";
        final Button submit = (Button)findViewById(R.id.button5);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add error if empty
                final String value = edit.getText().toString();
                //points = 0;
                //set image using an imageview
                if (value.equals("") || wrong.contains(value)) {
                    edit.setError("Please enter an answer choice");
                } else if (value.equals(answer[blockcount])) {
                    blocks[blockcount].setVisibility(View.INVISIBLE);
                    blocks[blockcount + 1].setVisibility(View.VISIBLE);
                    points += 4;
                    instruction.setText(instructionarray[blockcount]);
                    blockcount++;
                    edit.setText("");
                    pointto.setText("Points: " + String.valueOf(points));
                } else if (!(value.equals("")) && !(value.equals(answer[blockcount]))) {
                    blocks[blockcount].setVisibility(View.INVISIBLE);
                    blocks[blockcount + 1].setVisibility(View.VISIBLE);
                    edit.setError("Incorrect! You lost points!");
                    points -= 4;
                    instruction.setText(instructionarray[blockcount]);
                    blockcount++;
                    edit.setText("");
                    pointto.setText("Points: " + String.valueOf(points));
                }
                if (blockcount == 5){
                    startActivity(new Intent(math2.this, instructions.class));
                }
            }
        });
    }
}
