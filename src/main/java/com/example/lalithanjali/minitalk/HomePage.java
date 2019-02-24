package com.example.lalithanjali.minitalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        Button next = findViewById(R.id.loginButton);
        Button next1 = findViewById(R.id.registerButton);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Login.class);
                startActivityForResult(myIntent, 0);
            }
        });
        next1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view1) {
                Intent myIntent1 = new Intent(view1.getContext(), Register.class);
                startActivityForResult(myIntent1, 0);
            }
        });
    }
}
