package com.example.admin.exitpollapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "score.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "scoreTable";
    public static final String COL_ID = "_id";
    public static final String COL_SCORE = "score";
    public static final String COL_SCORENAME = "scorename";
    public static final String COL_IMAGE = "image";


    private static final String SQL_CREATE_TABLE_SCORE
            = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_SCORE + " TEXT,"
            + COL_SCORENAME + " TEXT,"
            + COL_IMAGE + " TEXT"

            + ")";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_SCORE);

        ContentValues cv = new ContentValues();
        cv.put(COL_SCORE, 0);
        cv.put(COL_SCORENAME, "score1");
        cv.put(COL_IMAGE, "one.png");


        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_SCORE, 0);
        cv.put(COL_SCORENAME, "score2");
        cv.put(COL_IMAGE, "two.png");


        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_SCORE, 0);
        cv.put(COL_SCORENAME, "score3");
        cv.put(COL_IMAGE, "three.png");


        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_SCORE, 0);
        cv.put(COL_SCORENAME, "scoreno");
        cv.put(COL_IMAGE, "vote_no.png");


        db.insert(TABLE_NAME, null, cv);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
