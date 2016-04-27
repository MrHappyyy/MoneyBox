package com.example.mrhappyyy.moneybox.fragments;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.example.mrhappyyy.moneybox.fragments.FragmentsView;

public class SettingsFragmentsView extends FragmentsView {
    private View rootView;
    private static final int POSITION = 3;

    public SettingsFragmentsView(View rootView, Context context){
        super(rootView, POSITION, context);
        this.rootView = rootView;
        rootView.setBackgroundColor(Color.CYAN);
    }
}
