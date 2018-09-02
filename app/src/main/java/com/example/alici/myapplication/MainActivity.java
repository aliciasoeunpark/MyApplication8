package com.example.alici.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.LocalDateTime;


public class MainActivity extends AppCompatActivity {

    public int hour, min;
    public int year, month, day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView t1 = findViewById(R.id.sis);
        TimePicker ttp = findViewById(R.id.tp);

        hour = ttp.getHour();
        min = ttp.getMinute();

        ttp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                hour = i;
                min = i1;
            }
        });

        DatePicker dp = findViewById(R.id.dp);

        year = dp.getYear();
        month = dp.getMonth();
        day = dp.getDayOfMonth();

        dp.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                year = i;
                month=i1;
                day=i2;
            }
        });


        Button upper01 =  findViewById(R.id.main1_button01);
        upper01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtra("year", year);
                i.putExtra("month", month);
                i.putExtra("day", day);
                i.putExtra("hour", hour);
                i.putExtra("min", min);
                startActivity(i);
            }
        });
        Button uppper01 =  findViewById(R.id.main1_button02);
        uppper01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtra("year", year);
                i.putExtra("month", month);
                i.putExtra("day", day);
                i.putExtra("hour", hour);
                i.putExtra("min", min);
                startActivity(i);
            }
        });

        Button upppper01 =  findViewById(R.id.main1_button03);
        upppper01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtra("year", year);
                i.putExtra("month", month);
                i.putExtra("day", day);
                i.putExtra("hour", hour);
                i.putExtra("min", min);
                startActivity(i);
            }
        });

        Button uppppper01 =  findViewById(R.id.main1_button04);
        uppppper01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtra("year", year);
                i.putExtra("month", month);
                i.putExtra("day", day);
                i.putExtra("hour", hour);
                i.putExtra("min", min);
                startActivity(i);
            }
        });




        ImageView upeer4 = findViewById(R.id.main1_imageView1);
        upeer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}