package com.example.myjamaat1lad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> masjids;
    ArrayList<String> prayerTimes;
    SQLiteDatabase masjidDatabase;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd = findViewById(R.id.btnAdd);
        ListView LOM = findViewById(R.id.LOM);

        //WORKS WITH DATABASE
        masjidDatabase = this.openOrCreateDatabase("MasjidData", MODE_PRIVATE, null);
        masjidDatabase.execSQL("CREATE TABLE IF NOT EXISTS zmasjids(id INTEGER PRIMARY KEY, name VARCHAR, Fazr VARCHAR, Zuhr VARCHAR, Asr VARCHAR, Maghrib VARCHAR, Esha VARCHAR )");
        masjidDatabase.execSQL("DELETE  FROM zmasjids WHERE name = 'R%'");
        masjidDatabase.execSQL("INSERT INTO zmasjids(name, Fazr, Zuhr, Asr, Maghrib, Esha) VALUES ('Rahmania Masjid' , '4.50', '1.30', '5.30', '6.38', '8.30' )");

        //DECLARING AND ADDING LISTVIEW AND ADAPTER
        masjids = new ArrayList<>();
        prayerTimes= new ArrayList<>();

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, masjids);
        LOM.setAdapter(arrayAdapter);

        //UPDATING LISTVIEW
        updateListView();

        LOM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDataPage = new Intent(getApplicationContext(), ShowData.class);
                showDataPage.putExtra("name", masjids.get(position));
                showDataPage.putExtra("prayerTimes", prayerTimes.get(position));
                startActivity(showDataPage);

            }
        });






    }

    public void updateListView(){
        Cursor cursor = masjidDatabase.rawQuery("SELECT * FROM  zmasjids", null);
        int nameIndex = cursor.getColumnIndex("name");
        int FazrIndex = cursor.getColumnIndex("Fazr");
        int ZuhrIndex = cursor.getColumnIndex("Zuhr");
        int AsrIndex = cursor.getColumnIndex("Asr");
        int MaghribIndex = cursor.getColumnIndex("Maghrib");
        int EshaIndex = cursor.getColumnIndex("Esha");
        cursor.moveToFirst();
        masjids.clear();
        prayerTimes.clear();
        while(!cursor.isAfterLast()){
            Log.i("name", cursor.getString(nameIndex));
            masjids.add(cursor.getString(nameIndex));
            prayerTimes.add("fazr  :  " + cursor.getString(FazrIndex) +"\n"
                    +"zuhr     :  " + cursor.getString(ZuhrIndex) +"\n"
                    + "Asr     :  " + cursor.getString(AsrIndex) +"\n"
                    +"maghrib  :  " + cursor.getString(MaghribIndex) +"\n"
                    +"esha     :  " + cursor.getString(EshaIndex));
            cursor.moveToNext();
        }
        cursor.close();
    }

    //TAKES TO THE DATAPAGE
    public  void addMasjid(View view){
        Intent showDataPage = new Intent(this, ShowData.class);
        Cursor cursor = masjidDatabase.rawQuery("SELECT * FROM  zmasjids", null);
        int nameIndex = cursor.getColumnIndex("name");
        int FazrIndex = cursor.getColumnIndex("Fazr");
        int ZuhrIndex = cursor.getColumnIndex("Zuhr");
        int AsrIndex = cursor.getColumnIndex("Asr");
        int MaghribIndex = cursor.getColumnIndex("Maghrib");
        int EshaIndex = cursor.getColumnIndex("Esha");
        cursor.moveToFirst();
        masjids.add(cursor.getString(nameIndex));
        arrayAdapter.notifyDataSetChanged();

        Log.i("a masjid  ", cursor.getString(nameIndex));
        showDataPage.putExtra("name", cursor.getString(nameIndex));
        showDataPage.putExtra("prayerTimes","fazr  :  " + cursor.getString(FazrIndex) +"\n" +"zuhr  :  " + cursor.getString(ZuhrIndex) +"\n"+ "Asr  :  " + cursor.getString(AsrIndex) +"\n"+"maghrib  :  " + cursor.getString(MaghribIndex) +"\n"+ "esha  :  " + cursor.getString(EshaIndex));
        cursor.close();
        startActivity(showDataPage);
    }
}