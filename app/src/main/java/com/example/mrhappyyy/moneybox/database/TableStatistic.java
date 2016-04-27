package com.example.mrhappyyy.moneybox.database;

public class TableStatistic {
    private static final String TABLE_NAME = "statistic";
    private static final String CREATE_TABLE = " " + TABLE_NAME + "";

    public static String getCreateTable() {
        return CREATE_TABLE;
    }
}
