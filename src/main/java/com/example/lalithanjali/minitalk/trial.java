package com.example.lalithanjali.minitalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class trial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trial);
        Button trial = (Button) findViewById(R.id.trial);
        Button register = (Button) findViewById(R.id.REGISTER);
        Button login = (Button) findViewById(R.id.LOGIN);
        trial.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Intent myIntent = new Intent(view.getContext(), Categories.class);
                //startActivity(myIntent);
                Intent myIntent = new Intent(view.getContext(), categories2.class);
                startActivity(myIntent);
            }

        });

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Intent myIntent = new Intent(view.getContext(), Categories.class);
                //startActivity(myIntent);
                Intent myIntent = new Intent(view.getContext(), Register.class);
                startActivity(myIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Intent myIntent = new Intent(view.getContext(), Categories.class);
                //startActivity(myIntent);
                Intent myIntent = new Intent(view.getContext(), Login.class);
                startActivity(myIntent);
            }
        });
    }
}
