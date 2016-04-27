package com.example.mrhappyyy.moneybox.fragments;

import android.content.Context;
import android.view.View;

public class FragmentsView {
    protected View rootView;
    private int position;
    protected Context context;

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
