package com.example.dictionary.dictionary;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3;
    EditText e1;
    TextView t1, t2, t3,t4;
    String meaning,string1,string2;
    Context ctx = this;
    Data data=new Data();
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        t1 = (TextView) findViewById(R.id.text_meaning);
        t2 = (TextView) findViewById(R.id.text_syno1);
        t3 = (TextView) findViewById(R.id.text_syno2);
        t3 = (TextView) findViewById(R.id.text_syno3);
            t4= (TextView) findViewById(R.id.text_word);
        e1 = (EditText) findViewById(R.id.Edit_text_search);
        b1 = (Button) findViewById(R.id.btn_search);
        b2 = (Button) findViewById(R.id.btn_synonim);
        b3= (Button) findViewById(R.id.btn_option);
            DatabaseOperations dp1 = new DatabaseOperations(ctx);
            Cursor cr1 = dp1.getInformation(dp1);
           if(! cr1.moveToFirst()) {

               Intent intent = new Intent(this, Insert.class);
               startActivity(intent);
           }
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //flag = sc.nextInt();

                    t2.setText("");
                t3.setText("");


                String word = e1.getText().toString();
                DatabaseOperations dop = new DatabaseOperations(ctx);
                Cursor cr = dop.getInformation(dop);
                cr.moveToFirst();


                do {

                    if (word.equals(cr.getString(0))) {
                        meaning = cr.getString(1).toString();
                        t1.setText(meaning);
                        t4.setText(word);
                        string1=cr.getString(2);
                        string2=cr.getString(3);

                        data.putHistory(word+"         "+meaning);
                        break;
                    }
                } while (cr.moveToNext());
                dop.closeDB();

               /* DatabaseOperations databaseOperations=new DatabaseOperations(ctx);
            long l=    databaseOperations.putHinformation(databaseOperations,word,meaning);
                String h=Long.toString(l);

                if(l!=0)
                {
                    Toast.makeText(getApplicationContext(), "history inserted"+h, Toast.LENGTH_LONG).show();
                }*/
               /* Cursor cursor=databaseOperations.getHinformation(databaseOperations);
                cursor.moveToFirst();

                String string=cr.getString(0).toString()+cr.getString(1).toString();
                t3.setText(string);*/

            }
        });


    }
public void option(View view)
{
    Intent intent=new Intent(this,OptionsActivity.class);
    intent.putExtra("history",data);
    startActivity(intent);
}
    public void senonym(View view)
    {
        t2.setText(string1);
        t3.setText(string2);
    }
    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }


}