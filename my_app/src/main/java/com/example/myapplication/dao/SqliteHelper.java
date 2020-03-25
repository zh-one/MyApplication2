package com.example.myapplication.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SqliteHelper extends SQLiteOpenHelper {


    private static SqliteHelper helper = null ;
    private static final String DB_FIle_Name   = "message.db" ;
    private static final int    DB_Version     = 1 ;
    private static List<SendMessage> list_db   = null ;


    public SqliteHelper(Context context){
        super(context,DB_FIle_Name,null,DB_Version) ;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SqlContent.Create_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertDB(SendMessage msg){
        getWritableDatabase().execSQL("insert into " +
                                   SqlContent.TABLE_Name + " values ( " +
                              "'"  +   msg.get_id()     + " ' " + " , "  +
                              "'"  +   msg.getTime()    + " ' " + " , "  +
                              "'"  +   msg.getContent() + " ' " + " , "  +
                              "'"  +   msg.getFromWho() + " ' " + " , "  +
                              "'"  +   msg.getToWho()   + " ' " +
                " ) ");
    }


    public List<SendMessage> getDBContent(){
        Cursor cursor =  getWritableDatabase().query(SqlContent.TABLE_Name,null,null,null,null,null ,null);

        if(null == list_db){
            list_db = new ArrayList<>() ;
        } else {
            list_db.clear();
        }

       while(cursor.moveToNext()){
           SendMessage msg = new SendMessage() ;
           msg.set_id(cursor.getString(0));
           msg.setTime(cursor.getString(1));
           msg.setContent(cursor.getString(2));
           msg.setMySending(new Random().nextBoolean());
           list_db.add(msg) ;
       }
        cursor.close();

        return list_db ;

    }

    public void closeDataBase(){
        getWritableDatabase().close();

    }

}
