package com.example.myjamaat1lad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.myjamaat1lad.MainActivity.arrayAdapter;



public class EditTime extends AppCompatActivity {

    EditText etName, ettFazr, ettZuhr, ettAsr, ettMaghrib, ettEsha;
    Switch swIsActive;
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
        swIsActive = findViewById(R.id.swIsActive);
        TextView tvHead = findViewById(R.id.tvHead);



    }

    public void addMasjid(View view){
        Masjid_Model newMasjid =  new Masjid_Model(-1, etName.getText().toString(), true, ettFazr.getText().toString(),
                                                    ettZuhr.getText().toString(), ettAsr.getText().toString(), ettMaghrib.getText().toString()
                                                    , ettEsha.getText().toString());
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.addOne(newMasjid);
        MainActivity.masjids = databaseHelper.getAll();
        arrayAdapter.notifyDataSetChanged();
        finish();
    }
    public void cancel(View view){
        finish();
    }
}