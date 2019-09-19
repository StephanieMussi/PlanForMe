package com.planforme.jamot.planforme.control.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.planforme.jamot.planforme.R;
import com.planforme.jamot.planforme.entity.Schedule;

import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.WeekFields;

import java.sql.SQLException;
import java.util.Locale;

public class DBHelper extends OrmLiteSqliteOpenHelper {

    /**
     * Database initialization
     */
    private static final String DATABASE_NAME = "PlanForMe.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<Schedule, Integer> scheduleDao = null;
    private RuntimeExceptionDao<Schedule, Integer> scheduleRuntimeDao = null;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    /**
     * This is called when the database is first created. Usually you should call createTable statements here to create
     * the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(DBHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, Schedule.class);
        } catch (SQLException e) {
            Log.e(DBHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }

        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int weekNo = LocalDate.now().get(woy);
        int year = LocalDate.now().getYear();

        // here we try inserting data in the on-create as a test
        RuntimeExceptionDao<Schedule, Integer> dao = getSimpleDataDao();
        long millis = System.currentTimeMillis();
        // init entries in the onCreate
        Schedule sch = new Schedule(weekNo, year);
        dao.create(sch);

        Log.i(DBHelper.class.getName(), "created new entries in onCreate: " + millis);
    }

    /**
     * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
     * the various data to match the new version number.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DBHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Schedule.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DBHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the Database Access Object (DAO) for our SimpleData class. It will create it or just give the cached
     * value.
     */
    public Dao<Schedule, Integer> getDao() throws SQLException {
        if (scheduleDao == null) {
            scheduleDao = getDao(Schedule.class);
        }
        return scheduleDao;
    }

    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our SimpleData class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<Schedule, Integer> getSimpleDataDao() {
        if (scheduleRuntimeDao == null) {
            scheduleRuntimeDao = getRuntimeExceptionDao(Schedule.class);
        }
        return scheduleRuntimeDao;
    }

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        scheduleDao = null;
        scheduleRuntimeDao = null;
    }
}