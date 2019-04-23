package com.example.dictionary.dictionary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Insert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        Context ct=this;
        DatabaseOperations dp = new DatabaseOperations(ct);
        dp.putInformation(dp,"absolute","total and complete","pure","exact");
        dp.putInformation(dp,"beautiful","having beauty","gorgeous","pretty");
        dp.putInformation(dp,"cool","fairly cold","chilly","cold");
        dp.putInformation(dp,"defeat","to win against somebody","loss","failure");
        dp.putInformation(dp,"easy","not hard","simple","painless");
        dp.putInformation(dp,"fabulous","extremeely good","awesome","fantastic");
        dp.putInformation(dp,"gentle","calm and quiet","pleasant","cool");
        dp.putInformation(dp,"helpful","able to improve a particular situation","favourable","friendly");
        dp.putInformation(dp,"glad","pleased","happy","proud");
        dp.putInformation(dp,"idol","a person who is loved verymuch","icon","hero");
        dp.putInformation(dp,"juice","a drink made from fruit","syrup","liquour");
        dp.putInformation(dp,"kid","a child or young man","naby","teenager");
        dp.putInformation(dp,"leader","a person who lead a group of people","head","chief");
        dp.putInformation(dp,"mother","female parent of a chield","mom","mommy");
        dp.putInformation(dp,"normal","what you would expect","natural","ordinary");
        dp.putInformation(dp,"ocean","mass of salt water which covers most part of earth","sea","deep");
        dp.putInformation(dp,"peace","a situation of free from violence","love","unity");
        dp.putInformation(dp,"quick","done with speed","fast","rapid");
        dp.putInformation(dp,"rare","seen very often","unique","limited");
        dp.putInformation(dp,"struggle","to try very hard to do something","battle","effort");
        dp.putInformation(dp,"teacher","a person whose job is to teach","schlar","advisor");
        dp.putInformation(dp,"universe","eeverything of earth, star,moon","world","everything");
        dp.putInformation(dp,"vast","extremely large","huge","big");
        dp.putInformation(dp,"white","having the colour of milk","pure","fair");
        dp.putInformation(dp,"x-ray","a type of radiation that can pass through  object that are not transparent and make it possible to see inside them","radioactivity","cathodray");
        dp.putInformation(dp,"young","having lived or exist for short time","new","growing");
        dp.putInformation(dp,"zoo","a place where many kinds of animals are kept for people to see","wildlife park","zoological garden");

    }
}
