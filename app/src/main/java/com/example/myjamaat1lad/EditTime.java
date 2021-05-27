package com.example.myjamaat1lad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.myjamaat1lad.MainActivity.arrayAdapter;
import static com.example.myjamaat1lad.MainActivity.masjidDatabase;
import static com.example.myjamaat1lad.MainActivity.updateListView;

public class EditTime extends AppCompatActivity {

    EditText etName, ettFazr, ettZuhr, ettAsr, ettMaghrib, ettEsha;
    String sqlValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_time);
        etName = findViewById(R.id.etName);
        ettFazr = findViewById(R.id.ettFazr);
        ettZuhr = findViewById(R.id.ettZuhr);
        ettAsr = findViewById(R.id.ettAsr);
        ettMaghrib = findViewById(R.id.ettMaghrib);
        ettEsha = findViewById(R.id.ettEsha);
        TextView tvHead = findViewById(R.id.tvHead);



    }

    public void addMasjid(View view){
        sqlValues = etName.getText()+"','"
                +ettFazr.getText()+"','"
                +ettZuhr.getText()+"','"
                +ettAsr.getText()+"','"
                +ettMaghrib.getText()+"','"
                +ettEsha.getText();
        masjidDatabase.execSQL("INSERT INTO zmasjids(name, Fazr, Zuhr, Asr, Maghrib, Esha) VALUES ('"+sqlValues+"')");
        Log.i("SqlValues", sqlValues);
        updateListView();
        arrayAdapter.notifyDataSetChanged();
        finish();
    }
    public void cancel(View view){
        finish();
    }
}