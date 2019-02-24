package com.example.lalithanjali.minitalk;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Locale;

import static com.example.lalithanjali.minitalk.Main4Activity.RESULT_SPEECH;

public class mainPage extends AppCompatActivity implements View.OnClickListener {
    private CountDownTimer countDownTimer;
    private boolean timerHasStarted = false;
    private Button startB;
    public TextView text;
    private final long startTime = 60 * 1000;
    private final long interval = 1 * 1000;
    private TextView textResult;

    private static MediaRecorder mediaRecorder;
    private static MediaPlayer mediaPlayer;

    // private static String audioFilePath;
    //private static Button stopButton;
    //private static Button playButton;
    //private static Button recordButton;

    private boolean isRecording = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        startB = (Button) this.findViewById(R.id.button);
        textResult = (TextView) findViewById(R.id.speech);
        startB.setOnClickListener((View.OnClickListener) this);
        text = (TextView) this.findViewById(R.id.timer);
        countDownTimer = new MyCountDownTimer(startTime, interval);
        text.setText(text.getText() + String.valueOf(startTime / 1000));


        /*VideoView videoView = findViewById(R.id.video_view);
        String videoPath = "android.resource://" +  getPackageName() +"/" + R.raw.video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(context:this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);*/
    }

   /* @Override
    public void onClick(View v) {

    }*/
   public void onClick(View view) {
            if (!timerHasStarted) {
                countDownTimer.start();
                timerHasStarted = true;
                startB.setText("START");

            }
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent,10);
            //new Auto_Stop_Task().execute();
        } else {
            Toast.makeText(this, "Your Device don't support speech input", Toast.LENGTH_SHORT).show();
        }
    }

    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            text.setText("Time's up!");

        }

        @Override
        public void onTick(long millisUntilFinished) {
            text.setText("" + millisUntilFinished / 1000);
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textResult.setText(result.get(0));
                }
                break;
        }
    }
}