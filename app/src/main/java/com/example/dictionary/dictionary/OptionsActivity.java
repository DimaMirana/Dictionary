package com.example.dictionary.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;
public class OptionsActivity extends AppCompatActivity {
TextView t;
    Button b1,b2,b3;
    Data data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        t= (TextView) findViewById(R.id.text_options);
        b1= (Button) findViewById(R.id.btn_history);
        b2= (Button) findViewById(R.id.btn_quiz);
        b3= (Button) findViewById(R.id.btn_point);
        Intent i=getIntent();
        data=(Data)i.getSerializableExtra("history");

    }
    public void history(View view)
    {
        Intent intent=new Intent(this,HistoryActivity.class);
        intent.putExtra("history",data);
        startActivity(intent);
    }
    public void quiz(View view)
    {
        Intent intent=new Intent(this,QuizActivity.class);
        startActivity(intent);

    }
    public void marks(View view)
    {
        Intent intent=new Intent(this,Ms.class);
        startActivity(intent);
    }
}
