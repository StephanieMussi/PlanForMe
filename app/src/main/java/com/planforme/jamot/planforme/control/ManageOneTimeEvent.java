package com.planforme.jamot.planforme.control;

import com.planforme.jamot.planforme.entity.Event;
import com.planforme.jamot.planforme.entity.OneTimeEvent;
import com.planforme.jamot.planforme.entity.Schedule;

import org.threeten.bp.LocalDateTime;

import static org.threeten.bp.temporal.ChronoUnit.HOURS;

public class ManageOneTimeEvent {
    private long eventID;
    private LocalDateTime dateTimeStart;
    private LocalDateTime dateTimeEnd;
    private String eventName;
    private float durationHrs;
    private float longitude;
    private float latitude;

    private Schedule sch;
    private String errorMsg;

    FetchSchedule fs = new FetchSchedule();

    /**
     * Default constructor for ManageOneTimeEvent.
     */
    public ManageOneTimeEvent() {
    }

    /**
     * Constructor for fetching Event given the event ID and the week and year of the schedule the event is in. (Used for editing)
     *
     * @param eventID Unique identifier for Event
     * @param year    Year of the schedule to look in
     * @param week    Week number of the schedule to look in
     */
    public ManageOneTimeEvent(long eventID, int year, int week) {
        fs.loadState();
        sch = fs.findScheduleByWeekYear(week, year);

        for (Event e : sch.getEventList()
                ) {
            if (e.getEventID() == eventID) {
                this.eventID = eventID;
                this.eventName = ((OneTimeEvent) e).getEventName();
                this.durationHrs = ((OneTimeEvent) e).getDurationHrs();
                this.longitude = ((OneTimeEvent) e).getLongitude();
                this.latitude = ((OneTimeEvent) e).getLatitude();
                this.dateTimeStart = ((OneTimeEvent) e).getDateTimeStart();
                this.dateTimeEnd = ((OneTimeEvent) e).getDateTimeEnd();
                break;
            }
        }
    }


    /**
     * Create a OneTimeEvent with location
     *
     * @param eventName     The name/title of the event
     * @param longitude     Longitude value of the location
     * @param latitude      Latitude value of the location
     * @param dateTimeStart The starting datetime for the event
     * @param dateTimeEnd   The ending datetime for the event
     * @return True if the operation is successful
     */
    public boolean createOneTimeEvent(String eventName, float longitude, float latitude,
                                      LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd) {
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd = dateTimeEnd;
        this.eventName = eventName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.durationHrs = HOURS.between(dateTimeStart, dateTimeEnd);

        if (eventName == "") {
            errorMsg = "Event name cannot be empty.";
            return false;
        }

        OneTimeEvent ote = new OneTimeEvent(eventName, durationHrs, longitude, latitude, dateTimeStart, dateTimeEnd);
        eventID = ote.getEventID();
        sch.getEventList().add(ote);
        fs.saveState();

        return true;
    }

    /**
     * Create OneTimeEvent without location
     *
     * @param eventName     The name/title of the event
     * @param dateTimeStart The starting datetime for the event
     * @param dateTimeEnd   The ending datetime for the event
     * @return True if the operation is successful
     */
    public boolean createOneTimeEvent(String eventName,
                                      LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd) {
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd = dateTimeEnd;
        this.eventName = eventName;
        this.durationHrs = HOURS.between(dateTimeStart, dateTimeEnd);

        if (eventName == "") {
            errorMsg = "Event name cannot be empty.";
            return false;
        }

        OneTimeEvent ote = new OneTimeEvent(eventName, durationHrs, dateTimeStart, dateTimeEnd);
        eventID = ote.getEventID();
        sch.getEventList().add(ote);
        fs.saveState();

        return true;
    }

    //TODO Validation for creation of event based on use case description.
    //TODO Update and Delete for OTE

    /**
     * Error message are generated whenever any operation fails (returns false)
     *
     * @return Generated error message.
     */
    public String getErrorMsg() {
        return errorMsg;
    }
}
