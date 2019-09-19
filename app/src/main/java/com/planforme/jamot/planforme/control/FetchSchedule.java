package com.planforme.jamot.planforme.control;

import android.app.Application;
import android.util.Log;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.planforme.jamot.planforme.control.sqlite.DBHelper;
import com.planforme.jamot.planforme.entity.Schedule;

import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.WeekFields;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;


public class FetchSchedule extends Application {
    private static Schedule schedule = null;
    private static File fileDir;

    /**
     * Default constructor for FetchSchedule. Load entities states upon creation.
     */
    public FetchSchedule() {
        loadState();
    }

    /**
     * Get the working directory used in android.
     *
     * @return The file path of the working directory.
     */
    public static File getFileDir() {
        return fileDir;
    }

    /**
     * Sets the file path of the working directory in android.
     */
    public static void setFileDir(File fileDir) {
        FetchSchedule.fileDir = fileDir;
    }

    /**
     * Iterates through the list of schedules and look for the schedule relevant to the given date.
     *
     * @param date Date that falls within the relevant schedule object.
     * @return Schedule object that the date falls in.
     */
    public static Schedule findScheduleByDate(LocalDate date) {
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int weekNo = date.get(woy);
        int year = date.getYear();

        return findScheduleByWeekYear(weekNo, year);
    }

    /**
     * Iterates through the list of schedules and look for the schedule relevant to the given week number and year.
     *
     * @param weekNo Week number of the schedule object.
     * @param year   Year int that schedule object is in.
     * @return Schedule object that the date falls in.
     */
    public static Schedule findScheduleByWeekYear(int weekNo, int year) {
        ConnectionSource cs = new AndroidConnectionSource(new DBHelper(ContextHandler.getContext()));

        try {
            Dao<Schedule, Integer> dao = DaoManager.createDao(cs, Schedule.class);
            schedule = null;

            QueryBuilder<Schedule, Integer> queryBuilder = dao.queryBuilder();
            queryBuilder.where().eq(Schedule.FIELD_NAME_WEEKNO, weekNo).and().eq(Schedule.FIELD_NAME_YEAR, year);
            schedule = queryBuilder.queryForFirst();

            if (schedule == null) {
                schedule = new Schedule(weekNo, year);
            }
            cs.close();

        } catch (SQLException e) {
            Log.e(DBHelper.class.getName(), "Schedule fetch error", e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return schedule;
    }

    /**
     * Saves the entire list of schedules into a file. (To be called after every data changing operation)
     */
    public void saveState() {
        int weekNo = schedule.getWeekNo();
        int year = schedule.getYear();

        ConnectionSource cs = new AndroidConnectionSource(new DBHelper(ContextHandler.getContext()));
        try {
            Dao<Schedule, Integer> dao = DaoManager.createDao(cs, Schedule.class);
            dao.update(schedule);
            cs.close();

        } catch (SQLException e) {
            Log.e(DBHelper.class.getName(), "Schedule update error", e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * Loads the entire list of schedules from a file. (To be called before any operation that involves schedule)
     */
    public void loadState() {
        ConnectionSource cs = new AndroidConnectionSource(new DBHelper(ContextHandler.getContext()));
        try {

            Dao<Schedule, Integer> dao = DaoManager.createDao(cs, Schedule.class);
            dao.refresh(schedule);
            cs.close();

        } catch (SQLException e) {
            Log.e(DBHelper.class.getName(), "Schedule refresh error", e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes the file that stores the list of schedules. (Should not be used other than for debugging)
     */
    public void resetState() {
        try {
            File file = new File(fileDir, "schedule.dat");
            if (file.exists())
                file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
