package com.onescious.droid.presidentsviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void showPresidents (View view) {
        TextView  tex = (TextView) findViewById(R.id.presidentnames);
        tex.setVisibility(View.VISIBLE);
    }
}
