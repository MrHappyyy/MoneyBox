package com.example.mrhappyyy.moneybox.fragments;

import android.graphics.Color;
import android.view.View;

import com.example.mrhappyyy.moneybox.fragments.FragmentsView;

public class StatisticsFragmentsView extends FragmentsView {
    private View rootView;

    public StatisticsFragmentsView(View rootView){
        super(rootView);
        this.rootView = rootView;
        rootView.setBackgroundColor(Color.RED);
    }

    public View getRootView() {
        return rootView;
    }
}
