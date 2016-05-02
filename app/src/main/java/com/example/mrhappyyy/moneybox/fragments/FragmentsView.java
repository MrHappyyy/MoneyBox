package com.example.mrhappyyy.moneybox.fragments;

import android.content.Context;
import android.view.View;

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
}
