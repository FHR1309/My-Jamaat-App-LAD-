package com.example.myjamaat1lad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvtime = findViewById(R.id.tvTime);
        Intent intent = getIntent();
        tvName.setText(intent.getStringExtra("name"));
        tvtime.setText(intent.getStringExtra("prayerTimes"));
    }
}