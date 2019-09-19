package com.planforme.jamot.planforme.entity;

import org.threeten.bp.LocalTime;

import java.io.Serializable;

import static org.threeten.bp.temporal.ChronoUnit.HOURS;

public class CurrentWeekEvent extends Event implements Serializable {

    private boolean splittable;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private boolean preferredDays[] = new boolean[7]; //TODO: Implement get and set
    private boolean outdoor;

    /**
     * Constructor for CurrentWeekEvent with location.
     *
     * @param splittable         Determines if the event can be split into different days.
     * @param preferredDays      Days in which the event should show up on after generating.
     * @param outdoor            Determines if the event is an outdoor activity. (affected by weather)
     * @param preferredTimeStart The preferred start time of the event for each preferred day.
     * @param preferredTimeEnd   The preferred end time of the event for each preferred day.
     * @param eventName          Name of the event.
     * @param longitude          The longitude value of the location the event takes place in.
     * @param latitude           The latitude value of the location the event takes place in.
     */
    public CurrentWeekEvent(boolean splittable, boolean[] preferredDays, boolean outdoor, LocalTime preferredTimeStart, LocalTime preferredTimeEnd, String eventName, float longitude, float latitude) {
        super(eventName, HOURS.between(preferredTimeEnd, preferredTimeEnd), longitude, latitude);

        this.splittable = splittable;
        this.timeStart = preferredTimeStart;
        this.timeEnd = preferredTimeEnd;

        for (int i = 0; i < preferredDays.length; i++) {
            this.preferredDays[i] = preferredDays[i];
        }

        this.outdoor = outdoor;
    }

    /**
     * Getter for splittable boolean
     *
     * @return Splittable
     */
    public boolean isSplittable() {
        return this.splittable;
    }

    /**
     * Setter for splittable boolean
     *
     * @param splittable
     */
    public void setSplittable(boolean splittable) {
        this.splittable = splittable;
    }

    /**
     * Getter for the start time of the event
     *
     * @return Start time of the event
     */
    public LocalTime getTimeStart() {
        return this.timeStart;
    }

    /**
     * Setter for the start time of the event
     *
     * @param timeStart
     */
    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    /**
     * Getter for the end time of the event
     *
     * @return End time of the event
     */
    public LocalTime getTimeEnd() {
        return this.timeEnd;
    }

    /**
     * Setter for the end time of the event
     *
     * @param timeEnd
     */
    public void setTimeEnd(LocalTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    /**
     * Getter for the outdoor status boolean
     *
     * @return Outdoor boolean
     */
    public boolean isOutdoor() {
        return this.outdoor;
    }

    /**
     * Setter for the outdoor status boolean
     *
     * @param outdoor
     */
    public void setOutdoor(boolean outdoor) {
        this.outdoor = outdoor;
    }

}