package com.planforme.jamot.planforme.entity;

import org.threeten.bp.LocalDateTime;

import java.io.Serializable;

public class OneTimeEvent extends Event implements Serializable {

    private LocalDateTime dateTimeStart;
    private LocalDateTime dateTimeEnd;


    /**
     * Constructor for OneTimeEvent without location
     *
     * @param eventName     The name/title of the event
     * @param durationHrs   The amount of hours this event takes
     * @param dateTimeStart The starting datetime for the event
     * @param dateTimeEnd   The ending datetime for the event
     */
    public OneTimeEvent(String eventName, float durationHrs, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd) {
        super(eventName, durationHrs);
        this.dateTimeEnd = dateTimeEnd;
        this.dateTimeStart = dateTimeStart;
    }

    /**
     * Constructor for OneTimeEvent with location
     *
     * @param eventName     The name/title of the event
     * @param durationHrs   The amount of hours this event takes
     * @param longitude     Longitude value of the location
     * @param latitude      Latitude value of the location
     * @param dateTimeStart The starting datetime for the event
     * @param dateTimeEnd   The ending datetime for the event
     */
    public OneTimeEvent(String eventName, float durationHrs, float longitude, float latitude,
                        LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd) {
        super(eventName, durationHrs, longitude, latitude);
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd = dateTimeEnd;
    }

    /**
     * Default constructor for OneTimeEvent
     */
    public OneTimeEvent() {
    }

    /**
     * Getter for the starting date time
     *
     * @return Starting date time
     */
    public LocalDateTime getDateTimeStart() {
        return this.dateTimeStart;
    }

    /**
     * Setter for the starting date time
     *
     * @param dateTimeStart
     */
    public void setDateTimeStart(LocalDateTime dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }

    /**
     * Getter for the starting date time
     *
     * @return
     */
    public LocalDateTime getDateTimeEnd() {
        return this.dateTimeEnd;
    }

    /**
     * Setter for the ending date time
     *
     * @param dateTimeEnd
     */
    public void setDateTimeEnd(LocalDateTime dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

}