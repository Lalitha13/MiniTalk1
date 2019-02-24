package com.example.lalithanjali.minitalk;

import android.os.CountDownTimer;
import android.os.Handler;
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

public class main3 extends AppCompatActivity implements View.OnClickListener {

    MediaRecorder recorder;
    private Button startBu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        startBu = (Button) this.findViewById(R.id.button);
        startBu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        //  recorder.setOutputFile(getFilename());
        //  recorder.setOnErrorListener(errorListener);
        // recorder.setOnInfoListener(infoListener);
        try {
            recorder.prepare();
            recorder.start();

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (null != recorder) {
                                startBu.setText("STOPPED");
                                recorder.stop();
                                recorder.reset();
                                recorder.release();
                                recorder = null;

                            }
                        }
                    });
                }
            }, 60000);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}