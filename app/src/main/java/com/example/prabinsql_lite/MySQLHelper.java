package com.example.prabinsql_lite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class MySQLHelper extends SQLiteOpenHelper {

    private static final String db_name="Dictionary";
    private static final int db_version=1;

    private static final String tbl_word="tblword";


    private static final String tbl_id="tblid";
    private static final String word="wordName";
    private static final String meaning="wordmeaning";


    public MySQLHelper(@Nullable Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + tbl_word  + "(" + tbl_id + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                word + " TEXGT, " + meaning + " TEXT " + ")";

        db.execSQL(query);

    }


    public long InsertData(String wordName, String word_meaning, SQLiteDatabase db){

        long id;
        ContentValues contentValues=new ContentValues();
        contentValues.put(word, wordName);
        contentValues.put(meaning, word_meaning);

        id=db.insert(tbl_word, null, contentValues);
        return id;

    }

    public List<Word> GetAllWords(SQLiteDatabase db){
        List<Word> dictionaryList=new ArrayList<>();
        Cursor cursor=db.rawQuery(" select * from tblword ", null);
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                dictionaryList.add(new Word(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            }
        }
        return dictionaryList;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
