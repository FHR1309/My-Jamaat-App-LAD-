package com.example.myjamaat1lad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String MASJID_TABLE_NAME = "tryMasjid1";
    public static final String COULUMN_MASJID_NAME = "masjidName";
    public static final String COULUMN_ID = "ID";
    public static final String COULUMN_ACTIVE_MASJID = "activeMasjid";
    public static final String FAZR_TIME = "fazrTime";
    public static final String ZUHR_TIME = "zuhrtime";
    public static final String ASR_TIME = "asrTime";
    public static final String MAGHRIB_TIME = "maghribTime";
    public static final String ESHA_TIME = "eshaTime";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "masjidstry1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + MASJID_TABLE_NAME + " (" + COULUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COULUMN_MASJID_NAME + " TEXT, " + COULUMN_ACTIVE_MASJID + " BOOL," +
                " " + FAZR_TIME + " text, " + ZUHR_TIME + " TEXT, " + ASR_TIME + " TEXT, " + MAGHRIB_TIME + " TEXT, " + ESHA_TIME + " TEXT )";
        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne (Masjid_Model masjidModel ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COULUMN_MASJID_NAME, masjidModel.getName());
        cv.put(COULUMN_ACTIVE_MASJID, masjidModel.isActive());
        cv.put(FAZR_TIME, masjidModel.getFazr());
        cv.put(ZUHR_TIME, masjidModel.getJuhr());
        cv.put(ASR_TIME, masjidModel.getAsr());
        cv.put(MAGHRIB_TIME, masjidModel.getMaghrib());
        cv.put(ESHA_TIME, masjidModel.getEsha());
        long insert = db.insert(MASJID_TABLE_NAME, null, cv);

        return insert != -1;


    }

    public boolean deleteOne(Masjid_Model masjidModel){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + MASJID_TABLE_NAME+ " WHERE " + COULUMN_ID + " = "+ masjidModel.getId();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            cursor.close();
            return true;
        }else {
            cursor.close();
            return false;
        }
    }

    public boolean editOne (Masjid_Model masjidModel ) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COULUMN_MASJID_NAME, masjidModel.getName());
        cv.put(COULUMN_ACTIVE_MASJID, masjidModel.isActive());
        cv.put(FAZR_TIME, masjidModel.getFazr());
        cv.put(ZUHR_TIME, masjidModel.getJuhr());
        cv.put(ASR_TIME, masjidModel.getAsr());
        cv.put(MAGHRIB_TIME, masjidModel.getMaghrib());
        cv.put(ESHA_TIME, masjidModel.getEsha());
        String id = Integer.toString(masjidModel.getId());
        db.update(MASJID_TABLE_NAME, cv, COULUMN_ID+ "= ?", new String[]{id});

        return true;

    }


        public List<Masjid_Model>  getAll (){
        List<Masjid_Model> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + MASJID_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){

            do {
                int masjidID = cursor.getInt(0);
                String masjidName = cursor.getString(1);
                boolean masjidActive = cursor.getInt(2) == 1;
                String fazr = cursor.getString(3);
                String zuhr = cursor.getString(4);
                String asr = cursor.getString(5);
                String maghrib = cursor.getString(6);
                String esha = cursor.getString(7);

                Masjid_Model newMasjid= new Masjid_Model( masjidID, masjidName, masjidActive, fazr, zuhr, asr, maghrib, esha);
                returnList.add(newMasjid);

            } while(cursor.moveToNext());

        } else{
            // FAILURE . DO NOT ADD ANYTHING
        }
        cursor.close();
        db.close();
        return  returnList;
    }

}
