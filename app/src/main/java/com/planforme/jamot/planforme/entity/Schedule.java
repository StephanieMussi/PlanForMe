package com.planforme.jamot.planforme.entity;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;

@DatabaseTable(tableName = "Schedule")
public class Schedule implements Serializable {

    public static final String FIELD_NAME_ID = "scheduleId";
    public static final String FIELD_NAME_WEEKNO = "weekNo";
    public static final String FIELD_NAME_YEAR = "year";
    public static final String FIELD_NAME_EVENTLIST = "eventList";

    @DatabaseField(generatedId = true, allowGeneratedIdInsert = true)
    private int scheduleId;
    @DatabaseField(uniqueCombo = true)
    private int weekNo;
    @DatabaseField(uniqueCombo = true)
    private int year;
    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private ArrayList<Event> eventList = new ArrayList<>();

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public Schedule() {
    }

    public Schedule(int weekNo, int year) {
        this.weekNo = weekNo;
        this.year = year;
    }

    /**
     * Checks if the current schedule corresponds to the week number and year.
     *
     * @param weekNo The week number of the year
     * @param year   The year the schedule is in
     * @return Boolean result of check
     */
    public boolean checkWeekYear(int weekNo, int year) {

        if (weekNo == this.weekNo && year == this.year)
            return true;

        return false;
    }

    public int getWeekNo() {
        return this.weekNo;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    /**
     * @param weekNo
     */
    public void setWeekNo(int weekNo) {
        this.weekNo = weekNo;
    }

    public int getYear() {
        return this.year;
    }

    /**
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

}