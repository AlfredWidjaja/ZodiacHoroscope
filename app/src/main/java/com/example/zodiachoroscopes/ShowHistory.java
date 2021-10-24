package com.example.zodiachoroscopes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowHistory extends AppCompatActivity {
    TextView show;
    int number=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_history);
        show = findViewById(R.id.textView);

        try{
            FileInputStream fileInputStream = openFileInput("Zodiac List.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuffer = new StringBuilder();

            String line;
            while((line = bufferedReader.readLine()) != null){
                if(line.contains("@")){
                    stringBuffer.append(number).append(") ");
                    number++;
                }
                stringBuffer.append(line).append("\n");
            }
            show.setText(stringBuffer.toString());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void homePage(View v){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

    public void checkPage(View v){
        Intent intent = new Intent(this, CheckZodiac.class);
        startActivity(intent);
    }

}