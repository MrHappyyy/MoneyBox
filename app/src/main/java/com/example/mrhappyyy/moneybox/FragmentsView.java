package com.example.mrhappyyy.moneybox;

import android.view.View;

public class FragmentsView {
    private View rootView;

    public FragmentsView(View rootView) {
        this.rootView = rootView;
    }

    public View getView() {
        return this.rootView;
    }
}
