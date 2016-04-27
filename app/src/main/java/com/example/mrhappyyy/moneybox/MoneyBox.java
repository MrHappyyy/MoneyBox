package com.example.mrhappyyy.moneybox;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.mrhappyyy.moneybox.database.DatabaseHelper;
import com.example.mrhappyyy.moneybox.fragments.SettingsFragmentsView;
import com.example.mrhappyyy.moneybox.fragments.StatisticsFragmentsView;
import com.example.mrhappyyy.moneybox.fragments.TasksFragmentsView;

public class MoneyBox extends AppCompatActivity {
    private static TasksFragmentsView tasksFragmentsView;
    private static StatisticsFragmentsView statisticsFragmentsView;
    private static SettingsFragmentsView settingsFragmentsView;
    private static DatabaseHelper databaseHandler;


    private SectionsPagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_money_box);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_money_box, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = null;

            if (databaseHandler == null) {
                databaseHandler = new DatabaseHelper(getContext());
            }

            /*TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));*/

            System.out.println(getArguments().getInt(ARG_SECTION_NUMBER));
            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    if (tasksFragmentsView == null) {
                        rootView = inflater.inflate(R.layout.tasks_money_box, container, false);
                        tasksFragmentsView = new TasksFragmentsView(rootView);
                    } else {
                        rootView = tasksFragmentsView.getView();
                    }
                    break;
                case 2:
                    if (statisticsFragmentsView == null) {
                        rootView = inflater.inflate(R.layout.statistics_money_box, container, false);
                        statisticsFragmentsView = new StatisticsFragmentsView(rootView);
                    } else {
                        rootView = statisticsFragmentsView.getView();
                    }
                    break;
                case 3:
                    if (settingsFragmentsView == null) {
                        rootView = inflater.inflate(R.layout.settings_money_box, container, false);
                        settingsFragmentsView = new SettingsFragmentsView(rootView);
                    } else {
                        rootView = settingsFragmentsView.getView();
                    }
                    break;
                default:
                    rootView = inflater.inflate(R.layout.activity_money_box, container, false);
            }

            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Цели";
                case 1:
                    return "Статистика";
                case 2:
                    return "Настройки";
            }
            return null;
        }
    }
}
