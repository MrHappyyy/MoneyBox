package com.example.mrhappyyy.moneybox.fragments;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;

import com.example.mrhappyyy.moneybox.R;
import com.example.mrhappyyy.moneybox.database.DatabaseHelper;
import com.example.mrhappyyy.moneybox.database.TaskEntity;
import com.example.mrhappyyy.moneybox.fragments.FragmentsView;

import java.util.ArrayList;

public class TasksFragmentsView extends FragmentsView {
    private static final int POSITION = 1;
    private static final String TASK_ENTITY_NAME = "task.entity";
    private String[] prevTasks;
    private ListView listView;

    public TasksFragmentsView(View rootView, Context context, DatabaseHelper databaseHandler){
        super(rootView, POSITION, context, databaseHandler);
        listView = (ListView) rootView.findViewById(R.id.listView);
        refresh();
        //databaseHandler.addTask(new TaskEntity(1, "s", 12.50, "12.07.2016", "12.07.2017"));
    }

    public void refresh() {
        ArrayList<TaskEntity> listTasks = databaseHelper.getAllTask();

        String[] tasks = new String[listTasks.size()];
        System.out.println(listTasks.size());
        for (int i = 0; i < listTasks.size(); i++) {
            tasks[i] = " " + listTasks.get(i).getId() + ". " + listTasks.get(i).getName() + " - " + listTasks.get(i).getPrice() + " грн.";
        }

        prevTasks = tasks;
        listView.setAdapter(getAdapter(tasks));
    }

    private ArrayAdapter<String> getAdapter(String[] tasks) {
        return new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, tasks);
    }
}