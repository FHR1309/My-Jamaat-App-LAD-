package com.example.myjamaat1lad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.myjamaat1lad.MainActivity.masjids;

public class ShowData extends AppCompatActivity {

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvFazr = findViewById(R.id.tvFazr);
        TextView tvZuhr = findViewById(R.id.tvZuhr);
        TextView tvAsr = findViewById(R.id.tvAsr);
        TextView tvMaghrib = findViewById(R.id.tvMaghrib);
        TextView tvEsha = findViewById(R.id.tvEsha);

        Intent intent = getIntent();
        position = Integer.parseInt(intent.getStringExtra("position"));

        try {

            tvName.setText(masjids.get(position).name);
            tvFazr.setText(masjids.get(position).fazr);
            tvZuhr.setText(masjids.get(position).juhr);
            tvAsr.setText(masjids.get(position).asr);
            tvMaghrib.setText(masjids.get(position).maghrib);
            tvEsha.setText(masjids.get(position).esha);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void deleteData(View view){
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        boolean b = databaseHelper.deleteOne(masjids.get(position));
        Toast.makeText(this,"Deleted id "+masjids.get(position).getId() + b, Toast.LENGTH_SHORT).show();
        masjids = databaseHelper.getAll();
        MainActivity.arrayAdapter.notifyDataSetChanged();
        finish();
    }
}