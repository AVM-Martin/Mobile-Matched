package id.my.avmmartin.matched.data.db;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.utils.Constants;

public class ScheduleManager extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "schedule";
    private static final int VERSION = 2;

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String LOCATION = "location";
    public static final String START_TIME = "starttime";
    public static final String END_TIME = "endtime";

    public int size() {
        try (SQLiteDatabase db = getReadableDatabase()) {
            return (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        }
    }

    // create read update delete

    public void insertSchedule(Schedule schedule) {
        try (SQLiteDatabase db = getWritableDatabase()) {
            db.insert(TABLE_NAME, null, schedule.toContentValues());
        }
    }

    public Schedule getScheduleById(int id) throws Exception {
        String selection = (
            ID + " = ?"
        );
        String[] selection_args = {
            Integer.toString(id)
        };

        try (SQLiteDatabase db = getReadableDatabase()) {
            try (Cursor cursor = db.query(TABLE_NAME, null, selection, selection_args, null, null, null)) {
                cursor.moveToFirst();
                return new Schedule(cursor);
            }
        }
    }

    public List<Schedule> getScheduleByDate(Calendar date) throws Exception {
        Calendar endRange = Calendar.getInstance();
        endRange.setTimeInMillis(date.getTimeInMillis());
        endRange.add(Calendar.DATE, 1);
        endRange.setTimeInMillis(endRange.getTimeInMillis() - 1);

        String selection = (
            START_TIME + " BETWEEN ? and ?"
        );
        String[] selection_args = {
            Long.toString(date.getTimeInMillis()),
            Long.toString(endRange.getTimeInMillis())
        };

        try (SQLiteDatabase db = getReadableDatabase()) {
            try (Cursor cursor = db.query(TABLE_NAME, null, selection, selection_args, null, null, null)) {
                List<Schedule> schedules = new ArrayList<>();

                while (cursor.moveToNext()) {
                    schedules.add(new Schedule(cursor));
                }

                return schedules;
            }
        }
    }

    public List<Schedule> getScheduleByMonth(Calendar date) throws Exception {
        Calendar endRange = Calendar.getInstance();
        endRange.setTimeInMillis(date.getTimeInMillis());
        endRange.add(Calendar.MONTH, 1);
        endRange.setTimeInMillis(endRange.getTimeInMillis() - 1);

        String selection = (
            START_TIME + " BETWEEN ? and ?"
        );
        String[] selection_args = {
            Long.toString(date.getTimeInMillis()),
            Long.toString(endRange.getTimeInMillis())
        };

        try (SQLiteDatabase db = getReadableDatabase()) {
            try (Cursor cursor = db.query(TABLE_NAME, null, selection, selection_args, null, null, null)) {
                List<Schedule> schedules = new ArrayList<>();

                while (cursor.moveToNext()) {
                    schedules.add(new Schedule(cursor));
                }

                return schedules;
            }
        }
    }

    public void updateSchedule(Schedule schedule) {
        String where_clause = (
            ID + " = ?"
        );
        String[] where_args = {
            Integer.toString(schedule.getId())
        };

        try (SQLiteDatabase db = getWritableDatabase()) {
            db.update(TABLE_NAME, schedule.toContentValues(), where_clause, where_args);
        }
    }

    // overridden method

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME + " TEXT, "
                + LOCATION + " TEXT, "
                + START_TIME + " INTEGER, "
                + END_TIME + " INTEGER"
                + ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL(
                "DROP TABLE IF EXISTS " + TABLE_NAME + ";"
            );
            onCreate(db);
        }
    }

    // constructor

    public ScheduleManager(Context context) {
        super(context, Constants.DB_NAME, null, VERSION);
    }
}
