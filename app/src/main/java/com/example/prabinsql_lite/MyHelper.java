package com.example.prabinsql_lite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {
    private static  final String db_name = "Dictionary";
    //DatabaseVersion
    private static  final int db_version = 1;
    //Table Name
    private static  final String tblName = "tblWord";
    //Cloumns
    private static  final String wordId = "wordId";
    private static  final String wordName = "wordName";
    private static  final String meaning= "meaning";
    //Constructor


    public MyHelper(@Nullable Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + tblName + "(" + wordId + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                wordName + "TEXT," + meaning + "TEXT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
