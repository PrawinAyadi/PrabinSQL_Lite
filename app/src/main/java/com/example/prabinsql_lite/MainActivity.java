package com.example.prabinsql_lite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prabinsql_lite.helper.MyHelper;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText word, meaning;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        word = findViewById(R.id.word);
        meaning = findViewById(R.id.meaning);
        add = findViewById(R.id.btnAdd);

        add.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        MyHelper helper = new MyHelper(this);
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();


        long id = helper.InsertData(word.getText().toString(), meaning.getText().toString(), sqLiteDatabase);
        if (id > 0) {
            Toast.makeText(this, "word added successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

        }
    }
}
