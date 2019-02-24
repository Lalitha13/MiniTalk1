package com.example.lalithanjali.minitalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button trial = (Button) findViewById(R.id.trial);
        Button register = (Button) findViewById(R.id.registernow);
        Button login = (Button) findViewById(R.id.login1);
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
