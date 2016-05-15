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
    private TableMoneyBox tMoneyBox;
    private TableTask tTask;
    private TableStatistic tStatistic;
    private ArrayList<TaskEntity> tasks;

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
        tMoneyBox = new TableMoneyBox(this);
        tTask = new TableTask(this);
        tStatistic = new TableStatistic(this);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTableDB(db);
    }

    private void createTableDB(SQLiteDatabase db) {
        db.execSQL(TableTask.getCreateTable());
        db.execSQL(TableMoneyBox.getCreateTable());
        db.execSQL(TableStatistic.getCreateTable());
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
        tasks.add(task);
        sortId(tasks.size() - 1);
    }

    private void sortId(int id) {
        int prevId;

        for (int i = id; i < tasks.size(); i++) {
            if (tasks.get(i).getId() != i + 1) {
                prevId = tasks.get(i).getId();
                tasks.get(i).setId(i + 1);
                tTask.update(prevId, tasks.get(i));
            }
        }
    }

    public ArrayList<TaskEntity> getAllTask() {
        if (tasks == null) {
            tasks = tTask.getAll();
        }
        return tasks;
    }

    public void updateTask(int id, TaskEntity entity) {
        entity.setId(id);
        tasks.get(id).setId(entity.getId());
        tasks.get(id).setName(entity.getName());
        tasks.get(id).setDataAdd(entity.getDataAdd());
        tasks.get(id).setDataEnd(entity.getDataEnd());
        tTask.update(id, entity);
    }

    public void deleteTask(int id) {
        tTask.delete(id);
        tasks.remove(id -1);
        sortId(id - 1);
    }

    public TaskEntity getByIdTask(int id) {
        return tTask.getById(id);
    }

    public double getMoney() {
        return tMoneyBox.getMoney();
    }

    public void setMoney(double money) {
        tMoneyBox.updateMoney(money);
    }

    public void addStatisticEvent(EventEntity event) {
        tStatistic.addEvent(event);
    }

    public ArrayList<EventEntity> getAllStatistics() {
        return tStatistic.getAllEvents();
    }
}