package com.example.admin.exitpollapp;



import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.exitpollapp.adapter.ScoreListAdapter;
import com.example.admin.exitpollapp.db.DatabaseHelper;
import com.example.admin.exitpollapp.model.ScoreItem;

import java.util.ArrayList;
import java.util.List;

import static com.example.admin.exitpollapp.db.DatabaseHelper.TABLE_NAME;
import static com.example.admin.exitpollapp.db.DatabaseHelper.COL_ID;
import static com.example.admin.exitpollapp.db.DatabaseHelper.COL_SCORE;
import static com.example.admin.exitpollapp.db.DatabaseHelper.COL_SCORENAME;
import static com.example.admin.exitpollapp.db.DatabaseHelper.COL_IMAGE;

//import static com.example.admin.exitpollapp.db.DatabaseHelper.COL_SCORE3;
//import static com.example.admin.exitpollapp.db.DatabaseHelper.COL_SCORENO;

public class WatchResultActivity extends AppCompatActivity {

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private List<ScoreItem> mScoreItemList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_result);

        mHelper = new DatabaseHelper(WatchResultActivity.this);
        mDb = mHelper.getWritableDatabase();

        Button clearButton = findViewById(R.id.button_clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
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



                    int newScore = 0;

                    DatabaseHelper helper = new DatabaseHelper(WatchResultActivity.this);
                    SQLiteDatabase db = helper.getWritableDatabase();

                    ContentValues cv = new ContentValues();

                    cv.put(COL_SCORE, newScore);

                    db.update(
                            TABLE_NAME,
                            cv,
                            COL_ID + " = ?",
                            new String[]{String.valueOf(id)}
                    );

                }
                c.close();

                /*Intent intent = new Intent(WatchResultActivity.this, WatchResultActivity.class);
                startActivity(intent);*/

                onResume();


            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadPhoneData();
       setupListView();
    }

    private void loadPhoneData() {


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

           /* Toast t = Toast.makeText(WatchResultActivity.this,scorename+" "+score,Toast.LENGTH_SHORT);
            t.show();*/

        }
        c.close();
    }

    private void setupListView() {
        /*ArrayAdapter<ScoreItem> adapter = new ArrayAdapter<>(
                WatchResultActivity.this,
                android.R.layout.simple_list_item_1,
                mScoreItemList
        );*/
        ScoreListAdapter adapter = new ScoreListAdapter(
                WatchResultActivity.this,
                R.layout.score_item,
                mScoreItemList
        );

        ListView lv = findViewById(R.id.result_list_view);
        lv.setAdapter(adapter);



    }
}
