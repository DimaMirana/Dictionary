package com.example.dictionary.dictionary;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
public class QuizActivity extends AppCompatActivity {
    EditText e;
    TextView t1,t2;
    Button b;
    int []r=new int[10];
    int i;
    int m=0,cA=0,wA=0;

    int c=0;

    String meaning;
    Random random=new Random();
    Context context=this;
    DatabaseOperations databaseOperations=new DatabaseOperations(context);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        e= (EditText) findViewById(R.id.Edit_text_answer);
        t1= (TextView) findViewById(R.id.text_question2);
        t2= (TextView) findViewById(R.id.text_result2);
        b= (Button) findViewById(R.id.btn_submit);

    }

    public void startQuiz(View view)
    {
        c=0;
        m=0;
        rGenerate();
    }

    public void submit(View view) {

    if (e.getText().toString().equals(meaning)) {

        for (int l=0;l<1000;l++)
        {
            t2.setText("");
        }

        t2.setText("Correct Answer!!!");
        m++;
        cA++;
        Data.marks=m;
        Data.correctAns=cA;
    }
    else {

        for (int m=0;m<1000;m++)
        {
            t2.setText("");
        }
        t2.setText("Wrong Answer!!");
        wA++;
        Data.wrongAns=wA;

    }
        c++;
        if(c<5)
        {
            e.setText("");
            rGenerate();
        }
        else
        {
            for (int k=0;k<5000;k++)
            {

            }
            e.setText("");
            t1.setText("");
            t2.setText("");
            Toast.makeText(getApplicationContext(), "Quiz over!!!", Toast.LENGTH_LONG).show();
        }
}
    public void rGenerate()
    {
        this.i=random.nextInt(20);
                for(int j=0;j<c;j++)
                {
                    if(r[j]==i)
                    {
                        reRgenerate();
                        j=-1;
                    }
                }
        r[c]=i;

        Cursor cursor=databaseOperations.getInformation(databaseOperations);
        cursor.moveToFirst();
        for(int j=0;j<i;j++)
        {
            cursor.moveToNext();
        }
        String word;
        word=cursor.getString(0).toString();
       this.meaning=cursor.getString(1).toString();
        t1.setText(word);


    }
    protected void onRestart()
    {
        super.onRestart();
        c=0;
        m=0;
        cA=0;
        wA=0;
        //rGenerate();
    }

    protected void onStop()
    {
        super.onStop();
        Data.marks=m;
    }
    public void reRgenerate()
    {
        this.i=random.nextInt(20);
    }
}
