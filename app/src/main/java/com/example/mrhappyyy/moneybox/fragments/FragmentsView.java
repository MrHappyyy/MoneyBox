package com.example.mrhappyyy.moneybox.fragments;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.mrhappyyy.moneybox.database.DatabaseHelper;

public class FragmentsView {
    protected View rootView;
    private int position;
    protected Context context;
    protected DatabaseHelper databaseHelper;

    public FragmentsView(View rootView, int position, Context context, DatabaseHelper databaseHelper) {
        this.rootView = rootView;
        this.position = position;
        this.context = context;
        this.databaseHelper = databaseHelper;
    }

    public FragmentsView(View rootView, int position, Context context) {
        this.rootView = rootView;
        this.position = position;
        this.context = context;
    }

    public int getPosition() {
        return position;
    }

    public View getView() {
        return this.rootView;
    }

    protected ArrayAdapter<String> getAdapter(String[] list) {
        return new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, list);
    }
}
