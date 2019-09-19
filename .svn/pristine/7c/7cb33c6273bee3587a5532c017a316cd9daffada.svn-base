package com.planforme.jamot.planforme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.planforme.jamot.planforme.control.FetchSchedule;
import com.planforme.jamot.planforme.entity.Event;
import com.planforme.jamot.planforme.entity.Schedule;

import org.threeten.bp.LocalDate;

public class EventListUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list_ui);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tv = (TextView) findViewById(R.id.testText);
        FetchSchedule fs = new FetchSchedule();
        Schedule sch = fs.findScheduleByDate(LocalDate.now());

        String eventListStr = new String();
        for (Event e : sch.getEventList()) {
            eventListStr += "\n" + e.getEventName();
        }

        tv.setText("Year: " + sch.getYear()
                + "\nWeek No: " + sch.getWeekNo()
                + "\nEventList size: " + sch.getEventList().size()
                + "\nEvent list: " + eventListStr);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
