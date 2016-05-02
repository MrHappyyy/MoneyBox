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
        databaseHandler.addTask(new TaskEntity(3, "sadhaujlsfldassf", 203.0, "fdszsdafxc", "fdsf"));
        //databaseHandler.delete(3);
        refresh();
    }

    public void refresh() {
        ArrayList<TaskEntity> listTasks = databaseHelper.getAllTask();

        String[] tasks = new String[listTasks.size()];

        for (int i = 0; i < listTasks.size(); i++) {
            TaskEntity entity = listTasks.get(i);
            tasks[i] = " " + entity.getId() + ". " + entity.getName() + " - " + entity.getPrice() + " грн.";
        }
        prevTasks = tasks;
        listView.setAdapter(getAdapter(tasks));
    }

    private ArrayAdapter<String> getAdapter(String[] tasks) {
        return new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, tasks);
    }
}