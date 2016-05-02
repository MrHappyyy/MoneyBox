package com.example.mrhappyyy.moneybox.database;

public class TableStatistic {
    private static final String TABLE_NAME = "statistic";
    private static final String CREATE_TABLE = " " + TABLE_NAME + "";

    public TableStatistic(DatabaseHelper databaseHelper) {

    }

    public static String getCreateTable() {
        return CREATE_TABLE;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }
}
