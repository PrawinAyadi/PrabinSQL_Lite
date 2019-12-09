package com.example.prabinsql_lite.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.example.prabinsql_lite.model.Word;

import java.util.ArrayList;
import java.util.List;

public class MyHelper extends SQLiteOpenHelper {

    private static final String db_name = "Dictionary";
    private static final int db_version = 1;

    //table name
    private static final String tblWord = "tblWord";
    //columns
    private static final String wordId = "wordId";
    private static final String wordName = "wordName";
    private static final String meaning = "meaning";

    //constructor
    public MyHelper(@Nullable Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//create
        String query = "CREATE TABLE " + tblWord +
                "("
                + wordId + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                wordName + " TEXT ,"
                + meaning + " TEXT" +
                ")";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if EXISTS "+tblWord);
        onCreate(db);

    }

    public long InsertData(String word, String meanings, SQLiteDatabase db) {
//insert
        ContentValues contentValues = new ContentValues();
        contentValues.put(wordName, word);
        contentValues.put(meaning, meanings);
        long id = db.insert(tblWord, null, contentValues);
        return id;


    }
    public List<Word> GetAllWords(SQLiteDatabase db){

        List<Word> dictionaryList = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from tblWord", null);
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                dictionaryList.add(new Word(cursor.getInt(0),cursor.getString(1), cursor.getString(2)));
            }
        }
        return dictionaryList;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
       return db.delete(tblWord, "wordID = ?", new String[]{id});

    }

}
