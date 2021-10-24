package com.example.zodiachoroscopes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    public void checkZodiac(View v){
        Intent check = new Intent(this, CheckZodiac.class);
        startActivity(check);
    }

    public void showHistory(View v){
        Intent show = new Intent(this, ShowHistory.class);
        startActivity(show);
    }
}