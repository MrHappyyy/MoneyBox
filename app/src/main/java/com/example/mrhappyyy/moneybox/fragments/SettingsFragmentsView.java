package com.example.mrhappyyy.moneybox.fragments;

import android.graphics.Color;
import android.view.View;

import com.example.mrhappyyy.moneybox.fragments.FragmentsView;

public class SettingsFragmentsView extends FragmentsView {
    private View rootView;

    public View getRootView() {
        return rootView;
    }

    public SettingsFragmentsView(View rootView){
        super(rootView);
        this.rootView = rootView;
        rootView.setBackgroundColor(Color.CYAN);
    }
}
