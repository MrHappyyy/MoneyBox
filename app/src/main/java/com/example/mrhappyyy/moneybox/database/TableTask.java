package com.example.mrhappyyy.moneybox.database;

public class TableTask {
    private static final String TABLE_NAME = "task";
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" +
            "'id' integer primary key autoincrement, ";

    public static String getCreateTable() {
        return CREATE_TABLE;
    }
}
