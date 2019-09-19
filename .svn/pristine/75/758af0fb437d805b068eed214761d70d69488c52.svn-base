package com.planforme.jamot.planforme;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.planforme.jamot.planforme.control.FetchWeatherForecast;

public class TestAPIsActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private EditText dayET;
    private FetchWeatherForecast forecast;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_apis);
        forecast = new FetchWeatherForecast(this);
        mTextMessage = (TextView) findViewById(R.id.message);
        dayET = (EditText) findViewById(R.id.dayET);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    protected void getWeatherForecast(View v) {
        mTextMessage.setText(forecast.getForecast(Integer.parseInt(dayET.getText().toString())));
    }

}
