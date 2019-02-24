package com.example.lalithanjali.minitalk;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class mainpage2 extends AppCompatActivity implements View.OnClickListener {
    private CountDownTimer countDownTimer;
    private boolean timerHasStarted = false;
    private Button startB;
    public TextView text;
    private final long startTime = 60 * 1000;
    private final long interval = 1 * 1000;
    //private TextView textResult;

    private static MediaRecorder mediaRecorder;
    private static MediaPlayer mediaPlayer;
    File audiofile;
    MediaRecorder recorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        startB = (Button) this.findViewById(R.id.button);
        //textResult = (TextView) findViewById(R.id.textView2);
        startB.setOnClickListener(this);
        text = (TextView) this.findViewById(R.id.timer);
        //countDownTimer = new MyCountDownTimer(startTime, interval);
        //text.setText(text.getText() + String.valueOf(startTime / 1000));
    }

    @Override
    public void onClick(View v) {
          /*  if (!timerHasStarted) {
                countDownTimer.start();
                timerHasStarted = true;
                startB.setText("START");
            }*/
        startB.setEnabled(false);
        File sampleDir = Environment.getExternalStorageDirectory();
        try {
            audiofile = File.createTempFile("sound", ".mp3", sampleDir);
        } catch (IOException e) {
            return;
        }
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        try {
            recorder.prepare();
            recorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Recording....", Toast.LENGTH_SHORT).show();
        startB.setText("STARTED");
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        startB.setText("STOP");
                        recorder.stop();
                    }
                });

            }
        }, 60000);

    }
}