package com.example.myapplication.dao;

public class SqlContent {

    public static final String TABLE_Name = "message" ;

    public static final String Create_Table = " create table if not exists " + TABLE_Name  +
                                              " (" +

                                              "_id     text " + " , " +
                                              "time    text " + " , " +
                                              "content text " + " , " +
                                              "fromWho text " + " , " +
                                              "towho   text " +

                                              ")" ;
}
