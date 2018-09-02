package com.example.alici.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.HashMap;




public class Main2Activity extends AppCompatActivity {

    public HashMap<String, Info> table = new HashMap<String, Info>();

    public String makeid(int year, int month, int day, int hour, int min){
        return ""+year+ (month < 10 ? "0"+ month : month) + (day<10? "0"+day : day) + (hour<10? "0"+hour : hour) + (min<10? "0"+min : min);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        insertData();


        ImageView upeer4 = findViewById(R.id.main2_imageView1);
        upeer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        final Intent me = getIntent();

        ImageView imageView2 = (ImageView)findViewById(R.id.main2_imageView2) ;
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                int year = me.getIntExtra("year", 0);
                int month = me.getIntExtra("month", 0) + 1;
                int day = me.getIntExtra("day", 0);
                int hour = me.getIntExtra("hour", 0);
                int min = me.getIntExtra("min", 0);

                String id = makeid(year, month,day,hour,min);

                Info data = table.get(id);
                if(data == null) {
                    Toast.makeText(getApplicationContext(), "선택하신 "+id +"에 해당하는 데이터가 없습니다", Toast.LENGTH_LONG).show();
                    return;
                }
                int score_temp = 0; // 온도
                if (data.getTemp() > 29) {
                    score_temp = 2;
                } else if (data.getTemp() < 27) {
                    score_temp = 10;
                } else if (data.getTemp() <= 29 && data.getTemp() >= 27) {
                    score_temp = 8;
                }
                int score_rain = 0; //강수량
                if (data.getRain() <= 60 && data.getTemp() >= 40) {
                    score_temp = 8;
                } else if (data.getTemp() >= 40) {
                    score_temp = 10;
                } else if (data.getTemp() >= 60) {
                    score_temp = 2;
                }
                int score_hour = 0; // 방문자수(시간대별로 점수부여)
                if (hour <= 13 && hour >= 12) {
                    score_hour = 2;
                } else if ((hour <= 10 && hour >= 9) || (hour <= 15 &&hour >= 14)) {
                    score_hour = 10;
                }else if((hour<=11&& hour>=10) || (hour<=2&&hour>=1))
                        score_hour =6;

             int score_distance = 0; //위치
                if (data.getDistance() <= 30) {
                    score_distance = 10;
                } else if (data.getDistance() <= 60) {
                    score_distance = 8;
                } else if (data.getDistance() <= 90) {
                score_distance = 6;
                } else if (data.getDistance() <= 120) {
                    score_distance = 4;
                } else
                    score_distance = 2;

                int score_price = 0; // 가격
                if (data.getPrice() >= 40) {
                    score_price = 0;
                }else if (data.getPrice() >= 20&& data.getPrice() <= 40) {
                    score_price = 4;
                }else if (data.getPrice() >= 10&& data.getPrice() <= 20) {
                            score_price = 6;
                }else if(data.getPrice() > 0&& data.getPrice() <10) {
                    score_price = 8;
                }else
                    score_price =0;

                int score_stay = 0; //평균머무는 시간
                if (data.getPrice() >= 180) {
                    score_price = 8;
                }else if (data.getPrice() >= 120&& data.getPrice() <= 180) {
                    score_price = 6;
                }else if (data.getPrice() >= 60 && data.getPrice() <=120) {
                    score_price = 4;
                }else if(data.getPrice() >= 30&& data.getPrice() <=60) {
                    score_price = 2;
                }else
                    score_price =0;

                SeekBar sb1 = findViewById(R.id.seekBar1);
                SeekBar sb2 = findViewById(R.id.seekBar2);
                SeekBar sb3 = findViewById(R.id.seekBar3);
                SeekBar sb4 = findViewById(R.id.seekBar4);
                SeekBar sb5 = findViewById(R.id.seekBar5);
                SeekBar sb6 = findViewById(R.id.seekBar6);



                double final_score = (score_temp*sb1.getProgress() + score_hour*sb2.getProgress() + score_distance*sb3.getProgress() +score_price*sb4.getProgress() + score_rain*sb5.getProgress() +score_stay*sb6.getProgress() )/6;


                Intent a = new Intent(getApplicationContext(),Main3Activity.class);
                a.putExtra("score", final_score);
                startActivity(a);
            }
        });

        SeekBar up1 = findViewById(R.id.seekBar1);
        up1.getProgress();


    }

    private void insertData() {

        table.put(makeid(2018, 8, 19, 12, 00), new Info(31, 500, 30, 14, 40, 2));
        table.put(makeid(2018, 8, 20, 13, 00), new Info(32, 400, 60, 14, 40, 2));
        table.put(makeid(2018, 8, 21, 14, 00), new Info(32, 400, 90, 14, 50, 2));
        table.put(makeid(2018, 8, 22, 15, 00), new Info(32, 400, 120, 14, 50, 2));
        table.put(makeid(2018, 8, 23, 16, 00), new Info(32, 400, 150, 14, 60, 2));
        table.put(makeid(2018, 8, 24, 17, 00), new Info(32, 400, 180, 14, 60, 2));
        table.put(makeid(2018, 8, 20, 18, 00), new Info(32, 400, 100, 14, 60, 2));
        table.put(makeid(2018, 8, 20, 19, 00), new Info(32, 400, 10, 14, 60, 2));

    }
}
