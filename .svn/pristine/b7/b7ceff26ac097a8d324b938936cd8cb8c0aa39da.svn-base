package com.planforme.jamot.planforme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.planforme.jamot.planforme.control.ContextHandler;
import com.planforme.jamot.planforme.control.CreateEvent;
import com.planforme.jamot.planforme.control.FetchSchedule;
import com.planforme.jamot.planforme.control.ManageRoutine;

import org.threeten.bp.LocalTime;


public class CalendarUI extends AppCompatActivity {

    private Button createEventBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_ui);

        ContextHandler.setContext(getApplicationContext());
        FetchSchedule.setFileDir(getApplicationContext().getFilesDir());
        ManageRoutine.setFileDir(getApplicationContext().getFilesDir());
    }

    protected void createEvent(View v) {

        CreateEvent ce = new CreateEvent(false, new boolean[7], false, LocalTime.now(), LocalTime.now(), "Test", 100, 100);

        ce.createNewEvent();
        ((Button) findViewById(R.id.createEvent)).setText("Created");


    }

    protected void gotoEventList(View v) {
        Intent eventList = new Intent(v.getContext(), EventListUI.class);
        startActivityForResult(eventList, 0);
    }

    protected void sync(View v) {
        Intent intentAPI = new Intent(v.getContext(), TestAPIsActivity.class);
        startActivity(intentAPI);
    }

}
