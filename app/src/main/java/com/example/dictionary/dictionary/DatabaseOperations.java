package com.example.dictionary.dictionary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Dima on 1/26/2017.
 */

public class DatabaseOperations extends SQLiteOpenHelper{

    public static final int databaseVersion=1;
    public  String command="CREATE TABLE " + TableData.TableInfo.tableName+"("+ TableData.TableInfo.WORD+" TEXT,"+ TableData.TableInfo.Meaning+" TEXT,"+ TableData.TableInfo.S1+" TEXT,"+ TableData.TableInfo.S2+" TEXT);";
    public String Hcommand="CREATE TABLE "+  HistoryTable.HtableInfo.Tabltename + "("  + HistoryTable.HtableInfo.Hword +" TEXT,"+ HistoryTable.HtableInfo.Hmeaning+" TEXT);";
    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
                db.execSQL(command);
               // db.execSQL(Hcommand);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putInformation(DatabaseOperations dop,String string1,String string2,String string3,String string4)
    {

        SQLiteDatabase SQ=dop.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(TableData.TableInfo.WORD,string1);
        cv.put(TableData.TableInfo.Meaning,string2);
        cv.put(TableData.TableInfo.S1,string3);
        cv.put(TableData.TableInfo.S2,string4);
        SQ.insert(TableData.TableInfo.tableName,null,cv);

        //dop.close();
    }
    public long putHinformation(DatabaseOperations db,String string1,String string2)
    {
        long i;
        SQLiteDatabase SQ=db.getWritableDatabase();
        ContentValues cv1=new ContentValues();
        cv1.put(HistoryTable.HtableInfo.Hword,string1);
        cv1.put(HistoryTable.HtableInfo.Hmeaning,string2);
       i= SQ.insert(HistoryTable.HtableInfo.Tabltename,null,cv1);
        db.close();
        return i;
       // SQ.close();
       // Log.d("message","history inserted!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

    }

    public Cursor getInformation(DatabaseOperations dop)
    {
        SQLiteDatabase SQ=dop.getReadableDatabase();
        String []coloums={TableData.TableInfo.WORD, TableData.TableInfo.Meaning, TableData.TableInfo.S1, TableData.TableInfo.S2};
        Cursor cr=SQ.query(TableData.TableInfo.tableName,coloums,null,null,null,null,null);
        //dop.close();
       // Log.d("message", "getInformation: ");
        return  cr;
    }
    public Cursor getHinformation(DatabaseOperations db)
    {
        SQLiteDatabase SQ=db.getReadableDatabase();
        String []hColoumns={HistoryTable.HtableInfo.Hword, HistoryTable.HtableInfo.Hmeaning};
        Cursor cr=SQ.query(HistoryTable.HtableInfo.Tabltename,hColoumns,null,null,null,null,null);
            db.close();
        return cr;
    }
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
