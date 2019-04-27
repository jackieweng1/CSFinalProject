package com.example.csfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class math3 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        final EditText edit = (EditText) findViewById(R.id.edit);
        final TextView pointtotal = (TextView) findViewById(R.id.pointtext);
        pointtotal.setText("Points " + Double.toString(points));
        final TextView equationtext = (TextView) findViewById(R.id.equations);
        blockcount = 0;
        final String[] answer = {"4", "4", "3", "4", "2", "3", "6", "2", "2"};
        final String[] equations = {"(5x - 3) + 4(2x - 3) = 37", "4x + 3 = 19", "2(4x + 2) - 2 = 26", "2(3x - 3) + 7 = 25", "2x + 5 = 3 x + 3", "2x - 5 = 6x - 17",
                "19 - 2x = 7", "4 = (2 + 3x) / 2", "4 = (2 + 3x) / 2"};
        final Button submit = (Button) findViewById(R.id.button6);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add error if empty
                final String value = edit.getText().toString();
                //points = 0;
                //set image using an imageview
                if (value.equals("")) {
                    edit.setError("Please enter an answer choice");
                } else if (value.equals(answer[blockcount])) {
                    points += 4;
                    blockcount++;
                    equationtext.setText(equations[blockcount]);
                    edit.setText("");
                    pointtotal.setText("Points: " + String.valueOf(points));
                } else if (!(value.equals("")) && !(value.equals(answer[blockcount]))) {
                    edit.setError("Incorrect! You lost points!");
                    points -= 4;
                    blockcount++;
                    equationtext.setText(equations[blockcount]);
                    edit.setText("");
                    pointtotal.setText("Points: " + String.valueOf(points));
                }
                if (blockcount == 8) {
                    startActivity(new Intent(math3.this, results.class));
                }
            }
        });
    }
}
