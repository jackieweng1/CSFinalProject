package com.example.csfinalproject;

import android.app.Activity;

public class BaseActivity extends Activity {
    protected static double points = 0.0;
    protected static int blockcount = 0;
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
}
