package com.example.mrhappyyy.moneybox.fragments;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.mrhappyyy.moneybox.R;
import com.example.mrhappyyy.moneybox.fragments.FragmentsView;

public class TasksFragmentsView extends FragmentsView {
    private static final int POSITION = 1;
    private GridLayout layout;
    private static final int ROWS = 4;
    private static final int COLUMN = 3;
    private static final Button[][]  buttonsXY = new Button[ROWS][COLUMN];

    public TasksFragmentsView(View rootView, Context context){
        super(rootView, POSITION, context);
        createFragments();
    }

    private void createFragments() {


    }
}
