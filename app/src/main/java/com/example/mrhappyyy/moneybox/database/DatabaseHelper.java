package com.example.mrhappyyy.moneybox.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MoneyBox";
    private static final int DATABASE_VERSION = 1;
    private TableTask tTask;
    private TableStatistic tStatistic;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        tTask = new TableTask(this);
        tStatistic = new TableStatistic(this);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TableTask.getCreateTable());
        //db.execSQL(TableStatistic.getCreateTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);

        db.execSQL("DROP TABLE IF IT EXISTS " + TableTask.getTableName());
        db.execSQL("DROP TABLE IF IT EXISTS " + TableStatistic.getTableName());

        onCreate(db);
    }

    public void addTask(TaskEntity task) {
        tTask.add(task);
        sortId();
    }

    private void sortId() {
        ArrayList<TaskEntity> tasks = getAllTask();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() != i + 1) {
                int prevId = tasks.get(i).getId();
                tasks.get(i).setId(i + 1);
                tTask.update(prevId, tasks.get(i));
            }
        }
    }

    public ArrayList<TaskEntity> getAllTask() {
        return tTask.getAll();
    }

    public void updateTask(int id, TaskEntity entity) {
        entity.setId(id);
        tTask.update(id, entity);
    }

    public void delete(int id) {
        tTask.delete(id);
        sortId();
    }

    public TaskEntity getById(int id) {
        return tTask.getById(id);
    }
}