package com.planforme.jamot.planforme.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public class Event implements Serializable, Cloneable {
    static final AtomicLong NEXT_ID = new AtomicLong(0);
    private long eventID = NEXT_ID.getAndIncrement();

    private String eventName = "";
    private float durationHrs;
    private float longitude;
    private float latitude;

    /**
     * changes the events ID, useful after cloning
     */
    private void updateEventID() {
        eventID = NEXT_ID.getAndIncrement();
    }

    /**
     * Default constructor for Event
     */
    public Event() {
    }

    /**
     * Get and returns the ID of the current Event instance
     *
     * @return ID of the event
     */
    public long getEventID() {
        return eventID;
    }

    /**
     * Constructor for Event with location
     *
     * @param eventName   The name/title of the event
     * @param durationHrs The amount of hours this event takes
     * @param longitude   Longitude value of the location
     * @param latitude    Latitude value of the location
     */
    public Event(String eventName, float durationHrs, float longitude, float latitude) {
        this.eventName = eventName;
        this.durationHrs = durationHrs;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * Constructor for event
     *
     * @param eventName   The name/title of the event
     * @param durationHrs The amount of hours this event takes
     */
    public Event(String eventName, float durationHrs) {
        this.eventName = eventName;
        this.durationHrs = durationHrs;
    }
    /**
     * Getter for longitude of the location
     *
     * @return Longitude
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Setter for longitude of the location
     *
     * @param longitude
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * Getter for latitude of the location
     *
     * @return Latitude
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Setter for latitude of the location
     *
     * @param latitude
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * Getter for the event name
     *
     * @return Event name
     */
    public String getEventName() {
        return this.eventName;
    }

    /**
     * Setter for the event name
     *
     * @param eventName
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Getter for the duration in hours
     *
     * @return Duration hours
     */
    public float getDurationHrs() {
        return this.durationHrs;
    }

    /**
     * Setter for the duration in hours
     *
     * @param durationHrs
     */
    public void setDurationHrs(float durationHrs) {
        this.durationHrs = durationHrs;
    }

    /**
     * @return will return a deep clone of this object
     * Note: the cloned objects will have different eventID's
     */
    public Event clone() {
        try {
            //serialising object
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            oos.close();

            //creating clone
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            Object obj = ois.readObject();
            ((Event) obj).updateEventID();
            return (Event) obj;
        } catch (IOException ex) {
            System.out.println("IOException cloning");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException cloning");
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (Float.compare(event.durationHrs, durationHrs) != 0) return false;
        if (Float.compare(event.longitude, longitude) != 0) return false;
        if (Float.compare(event.latitude, latitude) != 0) return false;
        return eventName != null ? eventName.equals(event.eventName) : event.eventName == null;
    }

    @Override
    public int hashCode() {
        int result = eventName != null ? eventName.hashCode() : 0;
        result = 31 * result + (durationHrs != +0.0f ? Float.floatToIntBits(durationHrs) : 0);
        result = 31 * result + (longitude != +0.0f ? Float.floatToIntBits(longitude) : 0);
        result = 31 * result + (latitude != +0.0f ? Float.floatToIntBits(latitude) : 0);
        return result;
    }
}