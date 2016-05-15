package com.example.mrhappyyy.moneybox.fragments;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.mrhappyyy.moneybox.R;
import com.example.mrhappyyy.moneybox.database.DatabaseHelper;
import com.example.mrhappyyy.moneybox.database.TaskEntity;

import java.util.ArrayList;

public class TasksFragmentsView extends FragmentsView {
    private static final int POSITION = 1;
    private static final String TASK_ENTITY_NAME = "task.entity";
    private String[] prevTasks;
    private ListView listView;
    private ArrayList<TaskEntity> listTasks;

    public TasksFragmentsView(View rootView, Context context, DatabaseHelper databaseHelper){
        super(rootView, POSITION, context, databaseHelper);
        //databaseHelper.addTask(new TaskEntity(1, "s", 12.50, "12.07.2016", "12.07.2017"));
        createView();

    }

    private void createView() {
        listView = (ListView) rootView.findViewById(R.id.listView);
        refreshListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    public void refreshListView() {
        listTasks = databaseHelper.getAllTask();

        String[] tasks = new String[listTasks.size()];

        for (int i = 0; i < listTasks.size(); i++) {
            tasks[i] = " " + listTasks.get(i).getId() + ". " + listTasks.get(i).getName() + " - " + listTasks.get(i).getPrice() + " грн.";
        }

        prevTasks = tasks;
        listView.setAdapter(getAdapter(tasks));
    }
}