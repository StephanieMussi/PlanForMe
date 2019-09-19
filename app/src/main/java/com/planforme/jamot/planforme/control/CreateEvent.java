package com.planforme.jamot.planforme.control;

import com.planforme.jamot.planforme.entity.CurrentWeekEvent;
import com.planforme.jamot.planforme.entity.Schedule;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

//THIS CLASS IS OBSOLETE AND SHOULD ONLY BE USED FOR REFERENCE. THANKS!

public class CreateEvent {

    private boolean splittable;
    private boolean preferredDays[];
    private boolean outdoor;

    private LocalTime preferredTimeStart;
    private LocalTime preferredTimeEnd;

    private String eventName;
    private float durationHr;

    private float longitude;
    private float latitude;

    Schedule sch;

    String errorMsg;

    FetchSchedule fs = new FetchSchedule();

    public CreateEvent(boolean splittable, boolean[] preferredDays, boolean outdoor, LocalTime preferredTimeStart, LocalTime preferredTimeEnd, String eventName, float longitude, float latitude) {
        this.splittable = splittable;
        this.preferredDays = preferredDays;
        this.outdoor = outdoor;
        this.preferredTimeStart = preferredTimeStart;
        this.preferredTimeEnd = preferredTimeEnd;
        this.eventName = eventName;
        this.longitude = longitude;
        this.latitude = latitude;

        fs.loadState();
        sch = fs.findScheduleByDate(LocalDate.now());

    }

    public boolean createNewEvent() {
        String regexTitle = "[a-zA-Z0-9_]";
        String regexTitleFirstChar = "[a-zA-Z_]";

        /*if (eventName == "") {
            errorMsg = "Event name cannot be empty.";
            return false;
        } else if (!eventName.trim().matches(regexTitle)){
            errorMsg = "Event name can only contain characters 'a-z' and 'A-Z', numbers '0-9' and underlines '_'.";
            return false;
        } else if(eventName.length() > 100){
            errorMsg = "Event name can only contain 100 characters.";
            return false;
        } else if(!eventName.substring(0,0).matches(regexTitleFirstChar)){
            errorMsg = "Event name must begin with characters 'a-z', 'A-Z' or underline '_'.";
            return false;
        }

        if(preferredTimeStart.isAfter(preferredTimeEnd)){
            errorMsg = "Start time must be selected before the end time.";
            return false;
        } else if(HOURS.between(preferredTimeStart, preferredTimeEnd) > 24){
            errorMsg = "The duration of the event must be less than 24 hours.";
            return false;
        }*/

        CurrentWeekEvent cwe = new CurrentWeekEvent(splittable, preferredDays, outdoor, preferredTimeStart, preferredTimeEnd, eventName, longitude, latitude);
        sch.getEventList().add(cwe);
        fs.saveState();

        return true;
    }

}
