package com.example.prabinsql_lite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class DisplayingWord extends AppCompatActivity {
    private ListView displayword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaying_word);

        displayword=findViewById(R.id.displayword);
        LoadWord();
    }

    private  void LoadWord(){
        final MySQLHelper mySQLHelper=new MySQLHelper(this);
        final SQLiteDatabase sqLiteDatabase = mySQLHelper.getWritableDatabase();

        List<Word> wordList = new ArrayList<>();
        wordList=mySQLHelper.GetAllWords(sqLiteDatabase);

        HashMap<String, String> hashMap=new HashMap<>();

        for(int i = 0; i <wordList.size(); i++){
            hashMap.put(wordList.get(i).getWordname(), wordList.get(i).getWordmeaning());

        }

        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,
                new ArrayList<String>(hashMap.keySet())
        );
        displayword.setAdapter(stringArrayAdapter);
    }
}
