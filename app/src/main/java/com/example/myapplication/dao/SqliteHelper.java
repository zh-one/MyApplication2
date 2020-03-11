package com.example.myapplication.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.myapplication.SendMessage;

import java.util.List;

public class SqliteHelper extends SQLiteOpenHelper {


    private static SqliteHelper helper = null ;
    private static final String DB_FIle_Name   = "message.db" ;
    private static final int    DB_Version     = 1 ;


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


       while(cursor.moveToNext()){
           Log.e("zhanglian" ,"the id is " + cursor.getColumnName(1)) ;
           Log.e("zhanglian" ,"the id is " + cursor.getCount()) ;
           Log.e("zhanglian" ,"the content is " + cursor.getString(2)) ;
       }

        return null ;

    }
}
