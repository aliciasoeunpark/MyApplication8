package com.example.alici.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent me = getIntent();
        double score = me.getDoubleExtra("score", 0.0f);
        TextView tv = findViewById(R.id.text08);
        tv.setText(""+score);

        ImageView upeer4 = findViewById(R.id.main3_imageView1);
        upeer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
