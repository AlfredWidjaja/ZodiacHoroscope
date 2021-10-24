package com.example.zodiachoroscopes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CheckZodiac extends AppCompatActivity {
    Spinner monthPick;
    EditText nameTxt, dateTxt, showZodiac;
    int date;
    String name, dates, month, zodiac, finalTxt, dateTime;
    String false_data = "Input date not valid";
    String input = "All input field must be filled";
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_zodiac);

        monthPick = findViewById(R.id.monthSelection);
        ArrayAdapter<CharSequence> adt = ArrayAdapter.createFromResource(this,
                R.array.month_spinner_items, android.R.layout.simple_spinner_item);
        adt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthPick.setAdapter(adt);
        nameTxt = findViewById(R.id.inputName);
        dateTxt = findViewById(R.id.input_dates);
        showZodiac = findViewById(R.id.show_zodiac);
        showZodiac.setText("");

    }

    public void checkZodiac(View v){
        name = nameTxt.getText().toString();
        dates = dateTxt.getText().toString();
        month = monthPick.getSelectedItem().toString();
        if(!name.isEmpty() && !dates.isEmpty()){
            date = Integer.parseInt(dates);
            switch (month){
                case "January":
                    if (date<21 && date>0){
                        zodiac = "Capricorn";
                    }else if (date>=21 && date<=31){
                        zodiac = "Aquarius";
                    }else{
                        zodiac = false_data;
                    }
                    break;
                case "February":
                    if (date<19 && date>0){
                        zodiac = "Aquarius";
                    }else if (date>=19 && date<=29){
                        zodiac = "Pisces";
                    }else{
                        zodiac = false_data;
                    }
                    break;
                case "March":
                    if (date<21 && date>0){
                        zodiac = "Pisces";
                    }else if (date>=21 && date<=31){
                        zodiac = "Aries";
                    }else{
                        zodiac = false_data;
                    }
                    break;
                case "April":
                    if (date<20 && date>0){
                        zodiac = "Aries";
                    }else if (date>=20 && date<=30){
                        zodiac = "Taurus";
                    }else{
                        zodiac = false_data;
                    }
                    break;
                case "May":
                    if (date<21 && date>0){
                        zodiac = "Taurus";
                    }else if (date>=21 && date<=31){
                        zodiac = "Gemini";
                    }else{
                        zodiac = false_data;
                    }
                    break;
                case "June":
                    if (date<21 && date>0){
                        zodiac = "Gemini";
                    }else if (date>=21 && date<=30){
                        zodiac = "Cancer";
                    }else{
                        zodiac = false_data;
                    }
                    break;
                case "July":
                    if (date<23 && date>0){
                        zodiac = "Cancer";
                    }else if (date>=23 && date<=31){
                        zodiac = "Leo";
                    }else{
                        zodiac = false_data;
                    }
                    break;
                case "August":
                    if (date<23 && date>0){
                        zodiac = "Leo";
                    }else if (date>=23 && date<=31){
                        zodiac = "Virgo";
                    }else{
                        zodiac = false_data;
                    }
                    break;
                case "September":
                    if (date<23 && date>0){
                        zodiac = "Virgo";
                    }else if (date>=23 && date<=30){
                        zodiac = "Libra";
                    }else{
                        zodiac = false_data;
                    }
                    break;
                case "October":
                    if (date<23 && date>0){
                        zodiac = "Libra";
                    }else if (date>=23 && date<=31){
                        zodiac = "Scorpio";
                    }else{
                        zodiac = false_data;
                    }
                    break;
                case "November":
                    if (date<22 && date>0){
                        zodiac = "Scorpio";
                    }else if (date>=22 && date<=30){
                        zodiac = "Sagittarius";
                    }else{
                        zodiac = false_data;
                    }
                    break;
                case "December":
                    if (date<22 && date>0){
                        zodiac = "Sagittarius";
                    }else if (date>=22 && date<=31){
                        zodiac = "Capricorn";
                    }else{
                        zodiac = false_data;
                    }
                    break;
                default:
                    break;
            }
            if (!zodiac.equals(false_data)){
                finalTxt = name + ", your zodiac is: " + zodiac;
            }else{
                finalTxt = false_data;
            }
        } else{
            finalTxt = input;
        }
        showZodiac.setText(finalTxt);
        finalTxt = "\t\tName: " + name + "\n\t\tZodiac is: " + zodiac + "\n";
    }

    @SuppressLint("SimpleDateFormat")
    public void saveData(View v) {
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd.LLL.yyyy @ HH:mm:ss");
        dateTime = "\n" + simpleDateFormat.format(calendar.getTime())
                + "\n\t\t~~~~~~~~~~~~~~~\n";

        if(showZodiac.getText().toString().equals("") ||
                showZodiac.getText().toString().equals(input) ||
                showZodiac.getText().toString().equals(false_data)){
            finalTxt = false_data;
        }else{
            try{
                FileOutputStream fileOutputStream = openFileOutput("Zodiac List.txt", MODE_APPEND);
                fileOutputStream.write(dateTime.getBytes());
                fileOutputStream.write(finalTxt.getBytes());
                fileOutputStream.close();

                Toast.makeText(this, "Data saved to Zodiac List.txt", Toast.LENGTH_SHORT).show();
                finalTxt = "";
            } catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        showZodiac.setText(finalTxt);
    }

    public void homePage(View v){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

    public void showPage(View v){
        Intent intent = new Intent(this, ShowHistory.class);
        startActivity(intent);
    }

}