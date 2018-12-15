package com.example.admin.exitpollapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.exitpollapp.db.DatabaseHelper;
import com.example.admin.exitpollapp.model.ScoreItem;

import java.util.ArrayList;
import java.util.List;

import static com.example.admin.exitpollapp.db.DatabaseHelper.COL_IMAGE;
import static com.example.admin.exitpollapp.db.DatabaseHelper.TABLE_NAME;
import static com.example.admin.exitpollapp.db.DatabaseHelper.COL_ID;
import static com.example.admin.exitpollapp.db.DatabaseHelper.COL_SCORE;
import static com.example.admin.exitpollapp.db.DatabaseHelper.COL_SCORENAME;



public class MainActivity extends AppCompatActivity {


    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private List<ScoreItem> mScoreItemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelper = new DatabaseHelper(MainActivity.this);
        mDb = mHelper.getWritableDatabase();

        Button score1Button = findViewById(R.id.button_select1);
        Button score2Button = findViewById(R.id.button_select2);
        Button score3Button = findViewById(R.id.button_select3);
        Button scorenoButton = findViewById(R.id.button_selectNo);

        Button watchResult = findViewById(R.id.button_watch);

       /* Cursor c = mDb.query(TABLE_NAME, null, null, null, null, null, null);
        int score = 0;
        String scorename = "";
        String image = "";
        long id = 0;
        mScoreItemList = new ArrayList<>();
        while (c.moveToNext()) {
            id = c.getLong(c.getColumnIndex(COL_ID));
            score = c.getInt(c.getColumnIndex(COL_SCORE));
            scorename = c.getString(c.getColumnIndex(COL_SCORENAME));
            image = c.getString(c.getColumnIndex(COL_IMAGE));
            ScoreItem item = new ScoreItem(id, score, scorename, image);
            mScoreItemList.add(item);
        }
        c.close();*/

        score1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = mDb.query(TABLE_NAME, null, null, null, null, null, null);
                int score = 0;
                String scorename = "";
                String image = "";
                long id = 0;
                mScoreItemList = new ArrayList<>();
                while (c.moveToNext()) {
                    id = c.getLong(c.getColumnIndex(COL_ID));
                    score = c.getInt(c.getColumnIndex(COL_SCORE));
                    scorename = c.getString(c.getColumnIndex(COL_SCORENAME));
                    image = c.getString(c.getColumnIndex(COL_IMAGE));
                    ScoreItem item = new ScoreItem(id, score, scorename, image);
                    mScoreItemList.add(item);
                }
                c.close();

            ScoreItem scoreitem = mScoreItemList.get(0);

                int newScore = scoreitem.score +1;

                DatabaseHelper helper = new DatabaseHelper(MainActivity.this);
                SQLiteDatabase db = helper.getWritableDatabase();

                ContentValues cv = new ContentValues();

                cv.put(COL_SCORE, newScore);

                db.update(
                        TABLE_NAME,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(scoreitem._id)}
                );

               /* Toast t = Toast.makeText(MainActivity.this,scoreitem.scoreName+" "+scoreitem.score,Toast.LENGTH_SHORT);
                t.show();*/


            }

        });

        score2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = mDb.query(TABLE_NAME, null, null, null, null, null, null);
                int score = 0;
                String scorename = "";
                String image = "";
                long id = 0;
                mScoreItemList = new ArrayList<>();
                while (c.moveToNext()) {
                    id = c.getLong(c.getColumnIndex(COL_ID));
                    score = c.getInt(c.getColumnIndex(COL_SCORE));
                    scorename = c.getString(c.getColumnIndex(COL_SCORENAME));
                    image = c.getString(c.getColumnIndex(COL_IMAGE));
                    ScoreItem item = new ScoreItem(id, score, scorename, image);
                    mScoreItemList.add(item);
                }
                c.close();

                ScoreItem scoreitem = mScoreItemList.get(1);

                int newScore = scoreitem.score +1;

                DatabaseHelper helper = new DatabaseHelper(MainActivity.this);
                SQLiteDatabase db = helper.getWritableDatabase();

                ContentValues cv = new ContentValues();

                cv.put(COL_SCORE, newScore);

                db.update(
                        TABLE_NAME,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(scoreitem._id)}
                );

               /* Toast t = Toast.makeText(MainActivity.this,scoreitem.scoreName+" "+scoreitem.score,Toast.LENGTH_SHORT);
                t.show();*/



            }
        });

        score3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = mDb.query(TABLE_NAME, null, null, null, null, null, null);
                int score = 0;
                String scorename = "";
                String image = "";
                long id = 0;
                mScoreItemList = new ArrayList<>();
                while (c.moveToNext()) {
                    id = c.getLong(c.getColumnIndex(COL_ID));
                    score = c.getInt(c.getColumnIndex(COL_SCORE));
                    scorename = c.getString(c.getColumnIndex(COL_SCORENAME));
                    image = c.getString(c.getColumnIndex(COL_IMAGE));
                    ScoreItem item = new ScoreItem(id, score, scorename, image);
                    mScoreItemList.add(item);
                }
                c.close();

                ScoreItem scoreitem = mScoreItemList.get(2);

                int newScore = scoreitem.score +1;

                DatabaseHelper helper = new DatabaseHelper(MainActivity.this);
                SQLiteDatabase db = helper.getWritableDatabase();

                ContentValues cv = new ContentValues();

                cv.put(COL_SCORE, newScore);

                db.update(
                        TABLE_NAME,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(scoreitem._id)}
                );

                /*Toast t = Toast.makeText(MainActivity.this,scoreitem.scoreName+" "+scoreitem.score,Toast.LENGTH_SHORT);
                t.show();*/



            }
        });

        scorenoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = mDb.query(TABLE_NAME, null, null, null, null, null, null);
                int score = 0;
                String scorename = "";
                String image = "";
                long id = 0;
                mScoreItemList = new ArrayList<>();
                while (c.moveToNext()) {
                    id = c.getLong(c.getColumnIndex(COL_ID));
                    score = c.getInt(c.getColumnIndex(COL_SCORE));
                    scorename = c.getString(c.getColumnIndex(COL_SCORENAME));
                    image = c.getString(c.getColumnIndex(COL_IMAGE));
                    ScoreItem item = new ScoreItem(id, score, scorename, image);
                    mScoreItemList.add(item);
                }
                c.close();

                ScoreItem scoreitem = mScoreItemList.get(3);

                int newScore = scoreitem.score +1;

                DatabaseHelper helper = new DatabaseHelper(MainActivity.this);
                SQLiteDatabase db = helper.getWritableDatabase();

                ContentValues cv = new ContentValues();

                cv.put(COL_SCORE, newScore);

                db.update(
                        TABLE_NAME,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(scoreitem._id)}
                );

                /*Toast t = Toast.makeText(MainActivity.this,scoreitem.scoreName+" "+scoreitem.score,Toast.LENGTH_SHORT);
                t.show();*/



            }
        });

        watchResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WatchResultActivity.class);
                startActivity(intent);
            }
        });

    }





}
