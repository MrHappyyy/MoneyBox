package com.example.mrhappyyy.moneybox.fragments;

import android.graphics.Color;
import android.view.View;

import com.example.mrhappyyy.moneybox.fragments.FragmentsView;

public class TasksFragmentsView extends FragmentsView {
    private View rootView;

    public TasksFragmentsView(View rootView){
        super(rootView);
        this.rootView = rootView;
        rootView.setBackgroundColor(Color.GREEN);
    }

    public View getRootView() {
        return rootView;
    }

    public void newColor() {
        rootView.setBackgroundColor(Color.BLACK);
    }
}
