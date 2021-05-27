package com.example.myjamaat1lad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TRY_MASJID_1 = "tryMasjid1";
    public static final String COULUMN_MASJID_NAME = "masjidName";
    public static final String COULUMN_ID = "ID";
    public static final String COULUMN_ACTIVE_MASJID = "activeMasjid";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "masjidstry.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + TRY_MASJID_1 + "(" + COULUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COULUMN_MASJID_NAME + " TEXT, " + COULUMN_ACTIVE_MASJID + " BOOL)";
        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
