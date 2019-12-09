package com.example.prabinsql_lite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;


import com.example.prabinsql_lite.adapter.WordAdapter;
import com.example.prabinsql_lite.helper.MyHelper;
import com.example.prabinsql_lite.model.Word;

import java.util.ArrayList;

import java.util.List;

public class WordDisplay extends AppCompatActivity {
    private RecyclerView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_display);

        lst = findViewById(R.id.wordlist);
        wordLoad();
    }

    private void wordLoad() {
        final MyHelper helper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();

        List<Word> wordList = new ArrayList<>();
        wordList = helper.GetAllWords(sqLiteDatabase);

//        final HashMap<String, String> hashMap = new HashMap<>();
//
//        for (int i = 0; i < wordList.size(); i++) {
//            hashMap.put(wordList.get(i).getWord(), wordList.get(i).getMeaning());
//        }
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, new ArrayList<String>(hashMap.keySet()));
//        lst.setAdapter(arrayAdapter);

        WordAdapter wordAdapter = new WordAdapter(this, wordList);
        lst.setAdapter(wordAdapter);
        lst.setLayoutManager(new LinearLayoutManager(this));

    }
}
