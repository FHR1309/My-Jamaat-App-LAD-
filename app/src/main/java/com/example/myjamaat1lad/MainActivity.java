package com.example.myjamaat1lad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView LOM = findViewById(R.id.LOM);
        ArrayList<String> masjids = new ArrayList<>();
        masjids.add("+ Add a new Masjid");
        Context context;
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, masjids);
        LOM.setAdapter(arrayAdapter);



    }
}