package com.example.lalithanjali.minitalk;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartPage extends AppCompatActivity {
    private static int TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);
        //final View myLayout = findViewById(R.id.);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(StartPage.this, trial.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
    }
    // Intent intent = new Intent(this, HomePage.class);
    //startActivity(intent);
    //finish();
}
