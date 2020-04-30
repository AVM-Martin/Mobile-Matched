package id.my.avmmartin.matched.data.db.model;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.Calendar;

import id.my.avmmartin.matched.data.db.ScheduleManager;
import id.my.avmmartin.matched.utils.Constants;

public class Schedule {
    private static final String ID = ScheduleManager.ID;
    private static final String NAME = ScheduleManager.NAME;
    private static final String LOCATION = ScheduleManager.LOCATION;
    private static final String START_TIME = ScheduleManager.START_TIME;
    private static final String END_TIME = ScheduleManager.END_TIME;
    private static final int NEW_SCHEDULE_ID = Constants.NEW_SCHEDULE_ID;

    private int id;
    private String name;
    private String location;
    private Calendar startTime;
    private Calendar endTime;

    public boolean isNewSchedule() {
        return getId() != NEW_SCHEDULE_ID;
    }

    // database-related method

    public Schedule(Cursor cursor) throws Exception {
        setId(cursor.getInt(cursor.getColumnIndex(ID)));
        setName(cursor.getString(cursor.getColumnIndex(NAME)));
        setLocation(cursor.getString(cursor.getColumnIndex(LOCATION)));

        Calendar startTime = Calendar.getInstance();
        startTime.setTimeInMillis(cursor.getInt(cursor.getColumnIndex(START_TIME)));
        setStartTime(startTime);

        Calendar endTime = Calendar.getInstance();
        startTime.setTimeInMillis(cursor.getInt(cursor.getColumnIndex(END_TIME)));
        setEndTime(endTime);
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME, getName());
        contentValues.put(LOCATION, getLocation());
        contentValues.put(START_TIME, getStartTime().getTimeInMillis());
        contentValues.put(END_TIME, getEndTime().getTimeInMillis());

        return contentValues;
    }

    // constructor

    public Schedule(String name, String location, Calendar startTime, Calendar endTime) throws Exception {
        setId(NEW_SCHEDULE_ID);
        setName(name);
        setLocation(location);
        setStartTime(startTime);
        setEndTime(endTime);
    }

    // getter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    // setter

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) throws Exception {
        if (name.equals("")) {
            this.name = "No Title";
        } else {
            this.name = name;
        }
    }

    private void setLocation(String location) throws Exception {
        if(location.equals("")) {
            this.location = "No Location";
        } else {
            this.location = location;
        }
    }

    private void setStartTime(Calendar startTime) throws Exception {
        this.startTime = startTime;
    }

    private void setEndTime(Calendar endTime) throws Exception {
        this.endTime = endTime;
    }
}
