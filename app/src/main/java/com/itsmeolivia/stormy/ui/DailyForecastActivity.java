package com.itsmeolivia.stormy.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.itsmeolivia.stormy.R;
import com.itsmeolivia.stormy.adapters.DayAdapter;
import com.itsmeolivia.stormy.weather.Day;

public class DailyForecastActivity extends ListActivity {

    private Day[] mDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        Intent intent = getIntent();
        mDays = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST, );

        DayAdapter adapter = new DayAdapter(this, mDays);
    }

}
