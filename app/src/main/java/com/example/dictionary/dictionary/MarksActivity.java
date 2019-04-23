package com.example.dictionary.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MarksActivity extends AppCompatActivity {
    TextView t1,t2,t3;
    String s,wAns,cAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks);
        t1= (TextView) findViewById(R.id.text_correctAns2);

        t2= (TextView) findViewById(R.id.text_wrongAns2);
        t3= (TextView) findViewById(R.id.text_marks2);
        s=Integer.toString(Data.marks);
        t3.setText(s);
        t3.setTextSize(20);
        wAns=Integer.toString(Data.wrongAns);
        t2.setText(wAns);
        t2.setTextSize(20);
        cAns=Integer.toString(Data.correctAns);
        t1.setText(cAns);
        t1.setTextSize(20);
    }

    protected void onRestart() {
        super.onRestart();
        s=Integer.toString(Data.marks);
        t3.setText(s);
        wAns=Integer.toString(Data.wrongAns);
        t2.setText(wAns);
        cAns=Integer.toString(Data.correctAns);
        t1.setText(cAns);

    }
}
