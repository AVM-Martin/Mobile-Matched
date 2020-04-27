package id.my.avmmartin.matched.data.db.model;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.Date;

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
    private Date startTime;
    private Date endTime;

    public Schedule(String name, String location, Date startTime, Date endTime) throws Exception {
        setId(NEW_SCHEDULE_ID);
        setName(name);
        setLocation(location);
        setStartTime(startTime);
        setEndTime(endTime);
    }

    public Schedule(Cursor cursor) throws Exception {
        setId(cursor.getInt(cursor.getColumnIndex(ID)));
        setName(cursor.getString(cursor.getColumnIndex(NAME)));
        setLocation(cursor.getString(cursor.getColumnIndex(LOCATION)));
        setStartTime(new Date(Long.parseLong(cursor.getString(cursor.getColumnIndex(START_TIME)))));
        setEndTime(new Date(Long.parseLong(cursor.getString(cursor.getColumnIndex(END_TIME)))));
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME, getName());
        contentValues.put(LOCATION, getLocation());
        contentValues.put(START_TIME, Long.toString(getStartTime().getTime()));
        contentValues.put(END_TIME, Long.toString(getEndTime().getTime()));

        return contentValues;
    }

    public boolean isNewSchedule() {
        return id == NEW_SCHEDULE_ID;
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

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    // setter

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) throws Exception {
        if (name.equals("")) {
            throw new Exception();
        } else {
            this.name = name;
        }
    }

    private void setLocation(String location) throws Exception {
        this.location = location;
    }

    private void setStartTime(Date startTime) throws Exception {
        this.startTime = startTime;
    }

    private void setEndTime(Date endTime) throws Exception {
        this.endTime = endTime;
    }
}
