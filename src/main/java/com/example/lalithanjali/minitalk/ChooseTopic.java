package com.example.lalithanjali.minitalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChooseTopic extends AppCompatActivity {
    EditText topic;
    String Topic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_topic);
        Button next1 = (Button) findViewById(R.id.categories);
       // Button next2 = (Button) findViewById(R.id.getReady);
        //topic = (EditText)findViewById(R.id.topic);
        //Topic = topic.getText().toString();


        next1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Categories.class);
                startActivityForResult(myIntent, 0);
            }
        });

        /*next2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), mainPage.class);
                startActivityForResult(myIntent, 0);
            }
        });*/
    }
}
