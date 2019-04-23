package com.example.dictionary.dictionary;

import android.provider.BaseColumns;

/**
 * Created by Dima on 1/6/2017.
 */

public class TableData {

    public static class TableInfo implements BaseColumns{
        public static final String WORD="word";
        public static final String Meaning="meaning";
        public static final String S1="s1";
        public static final String S2="s2";
        public static final String databaseName="dbName";
        public static final String tableName="tableName";
    }
}
