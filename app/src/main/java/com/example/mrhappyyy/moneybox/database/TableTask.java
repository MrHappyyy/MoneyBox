package com.example.mrhappyyy.moneybox.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TableTask {
    private static final String TABLE_NAME = "task";
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String PRICE_COLUMN = "price";
    private static final String DATA_ADD_COLUMN = "dateAdd";
    private static final String DATA_END_COLUMN = "dateEnd";
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" +
            "'"+ ID_COLUMN +"' integer primary key autoincrement, '"+ NAME_COLUMN +"' text, " +
            "'"+ PRICE_COLUMN +"' double, '" + DATA_ADD_COLUMN +"' text, '"+ DATA_END_COLUMN +"' text);";

    private SQLiteDatabase db;

    protected TableTask(DatabaseHelper databaseHelper) {
        db = databaseHelper.getWritableDatabase();
    }

    protected static String getTableName() {
        return TABLE_NAME;
    }

    protected static String getCreateTable() {
        return CREATE_TABLE;
    }

    protected ArrayList<TaskEntity> getAll() {
        ArrayList<TaskEntity> entities = new ArrayList<TaskEntity>();
        Cursor cursor = db.query(TABLE_NAME, new String[]{ID_COLUMN, NAME_COLUMN, PRICE_COLUMN, DATA_ADD_COLUMN, DATA_END_COLUMN},
                null, null, null, null, null);

        while (cursor.moveToNext()) {
            entities.add(new TaskEntity(
                    cursor.getInt(cursor.getColumnIndex(ID_COLUMN)),
                    cursor.getString(cursor.getColumnIndex(NAME_COLUMN)),
                    cursor.getDouble(cursor.getColumnIndex(PRICE_COLUMN)),
                    cursor.getString(cursor.getColumnIndex(DATA_ADD_COLUMN)),
                    cursor.getString(cursor.getColumnIndex(DATA_END_COLUMN))
            ));
        }
        cursor.close();
        return entities;
    }

    protected void add(TaskEntity task) {
        ContentValues values = new ContentValues();
        values.put(NAME_COLUMN, task.getName());
        values.put(PRICE_COLUMN, task.getPrice());
        values.put(DATA_ADD_COLUMN, task.getDataAdd());
        values.put(DATA_END_COLUMN, task.getDataEnd());
        db.insert(TABLE_NAME, null, values);
    }

    protected void delete(int id) {
        db.delete(TABLE_NAME, ID_COLUMN + "=?", new String[]{Integer.toString(id)});
    }

    protected void update(int id, TaskEntity entity) {
        ContentValues values = new ContentValues();
        values.put(ID_COLUMN, entity.getId());
        values.put(NAME_COLUMN, entity.getName());
        values.put(PRICE_COLUMN, entity.getPrice());
        values.put(DATA_ADD_COLUMN, entity.getDataAdd());
        values.put(DATA_END_COLUMN, entity.getDataEnd());

        db.update(TABLE_NAME, values, ID_COLUMN + "=?", new String[]{Integer.toString(id)});
    }
}
