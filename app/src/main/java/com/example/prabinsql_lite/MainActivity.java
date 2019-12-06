package com.example.prabinsql_lite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
// created
public class MainActivity extends AppCompatActivity {

    private EditText txtaddword, txtaddmeaning;
    private Button btnAddwords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtaddword=findViewById(R.id.txtaddword);
        txtaddmeaning=findViewById(R.id.txtaddmeaning);
        btnAddwords=findViewById(R.id.btnaddword);


        final MySQLHelper mySQLHelper=new MySQLHelper(MainActivity.this);
        final SQLiteDatabase sqLiteDatabase = mySQLHelper.getWritableDatabase();

        btnAddwords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               long id = mySQLHelper.InsertData(txtaddword.getText().toString(),
                       txtaddmeaning.getText().toString(), sqLiteDatabase);
               if(id > 0){
                   Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
               }


            }
        });
    }
}
