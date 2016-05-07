package com.example.mrhappyyy.moneybox.fragments;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ListView;

import com.example.mrhappyyy.moneybox.R;
import com.example.mrhappyyy.moneybox.database.DatabaseHelper;
import com.example.mrhappyyy.moneybox.database.EventEntity;
import com.example.mrhappyyy.moneybox.fragments.FragmentsView;

import java.util.ArrayList;

public class StatisticsFragmentsView extends FragmentsView {
    private View rootView;
    private static final int POSITION = 2;
    private ListView listView;
    private String[] prevStatistic;

    public StatisticsFragmentsView(View rootView, Context context, DatabaseHelper databaseHelper){
        super(rootView, POSITION, context, databaseHelper);
        this.rootView = rootView;
        createView();
    }

    private void createView() {
        listView = (ListView) rootView.findViewById(R.id.listView2);
        refresh();
    }

    public void refresh() {
        ArrayList<EventEntity> listEvents = databaseHelper.getAllStatistics();

        String[] events = new String[listEvents.size()];

        for (int i = 0; i < listEvents.size(); i++) {
            events[i] = listEvents.get(i).getEvent() +" - "+ listEvents.get(i).getDateEvent();
        }

        prevStatistic = events;
        listView.setAdapter(getAdapter(events));
    }
}