package com.example.dictionary.dictionary;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {
        TextView t1,t2;
    Context context=this;
    String sHistory="";
    DatabaseOperations db=new DatabaseOperations(context);
    Data data;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        t1= (TextView) findViewById(R.id.text_options);
        t2= (TextView) findViewById(R.id.text_showHISTORY);
        Intent intent=getIntent();
       data= (Data) intent.getSerializableExtra("history");

        sHistory=data.getHistory();
        t2.setText(sHistory);
    }
    protected void onRestart()
    {
        super.onRestart();
        sHistory=data.getHistory();
        t2.setText(sHistory);
    }
}
