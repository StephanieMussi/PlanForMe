package com.planforme.jamot.planforme.control;

import com.planforme.jamot.planforme.entity.Routine;

import org.threeten.bp.LocalTime;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ManageRoutine {

    private boolean daysAffected[];
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private String routineName;

    private List<Routine> routineArr = new ArrayList<>();

    private static File fileDir;

    String errorMsg;

    FetchSchedule fs = new FetchSchedule();

    public ManageRoutine() {
        loadState();
    }

    public ManageRoutine(String routineName, boolean[] daysAffected, LocalTime timeStart, LocalTime timeEnd) {
        loadState();

        this.routineName = routineName;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;

        for (int i = 0; i < daysAffected.length; i++) {
            this.daysAffected[i] = daysAffected[i];
        }
    }

    public static void setFileDir(File fileDir) {
        ManageRoutine.fileDir = fileDir;
    }

    public boolean createNewRoutine(String routineName, boolean[] daysAffected, LocalTime timeStart, LocalTime timeEnd) {
        try {
            Routine r = new Routine(routineName, daysAffected, timeStart, timeEnd);

            routineArr.add(r);
            saveState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean createNewRoutine() {
        try {
            Routine r = new Routine(routineName, daysAffected, timeStart, timeEnd);

            routineArr.add(r);
            saveState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<Routine> getRoutineList() {
        return routineArr;
    }

    public String getErrorMsg() {
        return errorMsg;
    }


    public void saveState() {
        try {
            File file = new File(ContextHandler.getContext().getFilesDir(), "routine.dat");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(routineArr);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadState() {
        try {
            File file = new File(ContextHandler.getContext().getFilesDir(), "routine.dat");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            routineArr = (ArrayList<Routine>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetState() {
        try {
            File file = new File(fileDir, "routine.dat");
            if (file.exists())
                file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
