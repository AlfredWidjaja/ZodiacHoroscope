package com.example.zodiachoroscopes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    CountDownTimer cdt;
    int progress = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProgressBar progressbar=(ProgressBar) findViewById(R.id.progressBar);
        progressbar.setMax(91);
        Intent intent = new Intent(this, MainPage.class);

        cdt = new CountDownTimer(5000, 50) {
            @Override
            public void onTick(long millisUntilFinished) {
                progressbar.setProgress(progress);
                progress++;
            }

            @Override
            public void onFinish() {
                startActivity(intent);
            }
        }.start();
    }
}