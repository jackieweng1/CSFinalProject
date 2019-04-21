package com.example.csfinalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class firstblock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstblock);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText edit = (EditText)findViewById(R.id.editText2);
        final String value = edit.getText().toString();

        final Button submit = (Button)findViewById(R.id.button4);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!(value.equals("6"))) {
                    edit.setError("That is incorrect!");
                } else {
                    startActivity(new Intent(firstblock.this, secondblock.class));
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
