package com.example.lalithanjali.minitalk;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class sample extends AppCompatActivity {
    private static final int REQUEST_CODE_SPPECH_INPUT = 1000;
    TextView mTextTv;
    ImageButton mVoiceBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        mTextTv = findViewById(R.id.textView);
        mVoiceBtn = findViewById(R.id.imageButton);

        mVoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });

    }

   /* public void onButtonClick(View v){
        if(v.getId() == R.id.imageButton){
             TextView result = (TextView)findViewById(R.id.TVresult);
             promptSpeechInput();
        }
    }*/
    public void speak(){
        Toast.makeText(sample.this,"Say Something",Toast.LENGTH_LONG).show();
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        /*i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say Something");*/
        try {

            startActivityForResult(i,REQUEST_CODE_SPPECH_INPUT);
        }catch(Exception e){
            Toast.makeText(sample.this,"Sorry your device does't support",Toast.LENGTH_LONG).show();

        }
    }
    public void onActivityResult(int request_code,int result_code,Intent data){
        super.onActivityResult(request_code,result_code,data);
        switch (request_code){
            case REQUEST_CODE_SPPECH_INPUT:if(result_code == RESULT_OK &&  null != data) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                mTextTv.setText(result.get(0));
            }
            break;
        }
    }
}

