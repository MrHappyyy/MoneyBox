package com.example.mrhappyyy.moneybox.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TableStatistic {
    private static final String ID_COLUMN = "id";
    private static final String EVENT_COLUMN = "event";
    private static final String DATA_EVENT_COLUMN = "dateEvent";
    private static final String TABLE_NAME = "statistic";
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" +
            "'"+ ID_COLUMN +"' integer primary key autoincrement, '"
            + EVENT_COLUMN +"' text, '"+ DATA_EVENT_COLUMN +"' text);";
    private SQLiteDatabase db;

    public TableStatistic(DatabaseHelper databaseHelper) {
        db = databaseHelper.getWritableDatabase();
    }

    protected static String getCreateTable() {
        return CREATE_TABLE;
    }

    protected static String getTableName() {
        return TABLE_NAME;
    }

    protected void addEvent(EventEntity entity) {
        ContentValues values = new ContentValues();
        values.put(EVENT_COLUMN, entity.getEvent());
        values.put(DATA_EVENT_COLUMN, entity.getDateEvent());
        db.insert(TABLE_NAME, null, values);
    }

    protected ArrayList<EventEntity> getAllEvents() {
        ArrayList<EventEntity> events = new ArrayList<EventEntity>();
        Cursor cursor = db.query(TABLE_NAME, new String[]{ID_COLUMN, EVENT_COLUMN, DATA_EVENT_COLUMN},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            events.add(new EventEntity(
                    cursor.getInt(cursor.getColumnIndex(ID_COLUMN)),
                    cursor.getString(cursor.getColumnIndex(EVENT_COLUMN)),
                    cursor.getString(cursor.getColumnIndex(DATA_EVENT_COLUMN))
            ));
        }
        cursor.close();
        return events;
    }
}
