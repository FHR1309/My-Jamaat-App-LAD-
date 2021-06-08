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
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static List<Masjid_Model> masjids;
    static ArrayAdapter<Masjid_Model> arrayAdapter;
    DatabaseHelper databaseHelper;
    static ListView LOM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd = findViewById(R.id.btnAdd);
        LOM = findViewById(R.id.LOM);



        //DECLARING AND ADDING LISTVIEW AND ADAPTER
        databaseHelper = new DatabaseHelper(MainActivity.this);
        masjids = databaseHelper.getAll();
        arrayAdapter = new ArrayAdapter<Masjid_Model>(this, android.R.layout.simple_list_item_1, masjids);
        LOM.setAdapter(arrayAdapter);



        LOM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDataPage = new Intent(getApplicationContext(), ShowData.class);
                showDataPage.putExtra("position", Integer.toString(position));
                startActivity(showDataPage);

            }
        });






    }

    public  void updateListView(){
        masjids = databaseHelper.getAll();
        arrayAdapter.notifyDataSetChanged();
    }

    //TAKES TO THE DATAPAGE
    public  void toEditTimeActivity(View view){
        Intent toEditTime = new Intent(this, EditTime.class);

        Log.i("editTime  ", "1234");
        //toEditTime.putExtra("name", "a");
        //toEditTime.putExtra("","");
        startActivity(toEditTime);
    }
}