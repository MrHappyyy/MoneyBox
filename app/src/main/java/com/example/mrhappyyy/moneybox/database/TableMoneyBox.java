package com.example.mrhappyyy.moneybox.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TableMoneyBox {
    private static final String TABLE_NAME = "moneyBox";
    private static final String ID_COLUMN = "id";
    private static final String MONEY_COLUMN = "money";
    private static final int ID_MONEY = 1;
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" +
            "'"+ ID_COLUMN +"' integer primary key autoincrement, '"+ MONEY_COLUMN  +"' double);";
    private SQLiteDatabase db;

    protected TableMoneyBox(DatabaseHelper databaseHelper) {
        db = databaseHelper.getWritableDatabase();

        if (getMoney() == -1) {
            setMoney(0);
        }
    }

    protected static String getTableName() {
        return TABLE_NAME;
    }

    protected static String getCreateTable() {
        return CREATE_TABLE;
    }

    private void setMoney(double money) {
        ContentValues values = new ContentValues();
        values.put(ID_COLUMN, ID_MONEY);
        values.put(MONEY_COLUMN, money);
        db.insert(TABLE_NAME, null, values);
    }

    protected double getMoney() {
        Cursor cursor = db.query(TABLE_NAME, new String[]{ID_COLUMN, MONEY_COLUMN},
                null, null, null, null, null);
        double money = -1;
        while (cursor.moveToNext()) {
            if (cursor.getInt(cursor.getColumnIndex(ID_COLUMN)) == ID_MONEY) {
                if (cursor.getDouble(cursor.getColumnIndex(MONEY_COLUMN)) > 0) {
                    money = cursor.getDouble(cursor.getColumnIndex(MONEY_COLUMN));
                } else {
                    money = 0;
                }
                break;
            }
        }
        cursor.close();
        return money;
    }

    protected void updateMoney(double money) {
        ContentValues values = new ContentValues();
        values.put(ID_COLUMN, ID_MONEY);
        values.put(MONEY_COLUMN, money);
        db.update(TABLE_NAME, values, ID_COLUMN + "=?", new String[]{Integer.toString(ID_MONEY)});
    }
}
