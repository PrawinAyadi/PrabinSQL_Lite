package com.example.prabinsql_lite;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prabinsql_lite.helper.MyHelper;


public class WordDetail extends AppCompatActivity {
    MyHelper db;
    private TextView textView;
    Button delete, edit;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_detail);
        textView = findViewById(R.id.tv1);
        delete = findViewById(R.id.delete);
        edit = findViewById(R.id.edit);
        editText = findViewById(R.id.edID);
        db = new MyHelper(this);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String means = bundle.getString("Meaning");
            int ID = bundle.getInt("Id");
            editText.setId(ID);
            textView.setText(means);
        } else {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();

        }
        del();

    }

    public void del() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteRow = db.deleteData(editText.getText().toString());
                if (deleteRow > 0)
                    Toast.makeText(WordDetail.this, "deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(WordDetail.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
