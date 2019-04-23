package com.example.dictionary.dictionary;
import android.content.Context;


/**
 * Created by Dima on 1/6/2017.
 */

public class InsertData  {

    Context ctx;
    public InsertData(Context context)
    {
        ctx=context;
    }

    DatabaseOperations dp=new DatabaseOperations(ctx);

   // dp.putInformation(dp,"absolute","total and complete","pure","exact");

}
