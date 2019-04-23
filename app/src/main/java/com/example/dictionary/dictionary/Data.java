package com.example.dictionary.dictionary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * Created by Dima on 1/26/2017.
 */

public class Data implements Serializable{
    public static int marks;
    public static int correctAns;
    public static int wrongAns;
    String s="";
    public ArrayList<String> H =new ArrayList<String>();
   public LinkedHashSet<String> l=new LinkedHashSet<String>();
    public void putHistory(String string){
        H.add(string);
        this.removeDup();
    }
    public void removeDup()
    {
        l.addAll(H);
        H.clear();
        H.addAll(l);
    }
    public String getHistory()
    {
        s="";
        for(int i=0;i<H.size();i++)
        {
            s=s+H.get(i)+"\n";
        }
        return s;
    }
}
