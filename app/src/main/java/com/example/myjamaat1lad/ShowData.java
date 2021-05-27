package com.example.myjamaat1lad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.myjamaat1lad.MainActivity.arrayAdapter;
import static com.example.myjamaat1lad.MainActivity.masjidDatabase;

public class ShowData extends AppCompatActivity {

    String position;

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
        tvName.setText(intent.getStringExtra("name"));
        position = intent.getStringExtra("position");
        try {
            Cursor cursor = masjidDatabase.rawQuery("SELECT * FROM  zmasjids WHERE id ="+position+"", null);
            int nameIndex = cursor.getColumnIndex("name");
            int FazrIndex = cursor.getColumnIndex("Fazr");
            int ZuhrIndex = cursor.getColumnIndex("Zuhr");
            int AsrIndex = cursor.getColumnIndex("Asr");
            int MaghribIndex = cursor.getColumnIndex("Maghrib");
            int EshaIndex = cursor.getColumnIndex("Esha");
            cursor.moveToFirst();

            tvFazr.setText(cursor.getString(FazrIndex));
            tvZuhr.setText(cursor.getString(ZuhrIndex));
            tvAsr.setText(cursor.getString(AsrIndex));
            tvMaghrib.setText(cursor.getString(MaghribIndex));
            tvEsha.setText(cursor.getString(EshaIndex));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void deleteData(View view){
        masjidDatabase.execSQL("DELETE FROM zmasjids WHERE id ="+ Integer.toString(Integer.parseInt(position) + 1));
        MainActivity.updateListView();
        arrayAdapter.notifyDataSetChanged();
        finish();
    }
}