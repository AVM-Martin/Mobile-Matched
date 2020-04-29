package id.my.avmmartin.matched.data.db;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.utils.Constants;

public class ScheduleManager extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "schedule";
    private static final int VERSION = 1;

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String LOCATION = "location";
    public static final String START_TIME = "starttime";
    public static final String END_TIME = "endtime";

    public ScheduleManager(Context context) {
        super(context, Constants.DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME + " TEXT, "
                + LOCATION + " TEXT, "
                + START_TIME + " TEXT, "
                + END_TIME + " TEXT"
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

    public Schedule getScheduleById(int id) throws Exception {
        String selection = (
            ID + " = ?"
        );
        String[] selection_args = {
            Integer.toString(id)
        };

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, selection, selection_args, null, null, null);

        try {
            cursor.moveToFirst();
            return new Schedule(cursor);

        } finally {
            cursor.close();
            db.close();
        }
    }

    public List<Schedule> getScheduleByDate(String date) throws Exception {
        List<Schedule> schedules = new ArrayList<>();

        String selection = (
            START_TIME + " = ?"
        );
        String[] selection_args = {
            date
        };

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, selection, selection_args, null, null, null);

        try {
            while(cursor.moveToNext()) {
                schedules.add(new Schedule(cursor));
            }
            return schedules;
        } finally {
            cursor.close();
            db.close();
        }
    }

    public List<Schedule> getScheduleByMonth(String month, String year) {
        List<Schedule> schedules = new ArrayList<>();

        return schedules;
    }

    public void insertSchedule(Schedule schedule) {
        SQLiteDatabase db = getWritableDatabase();

        if (schedule.isNewSchedule()) {
            db.insert(TABLE_NAME, null, schedule.toContentValues());

        } else {
            String where_clause = (
                ID + " = ?"
            );
            String[] where_args = {
                Integer.toString(schedule.getId())
            };

            db.update(TABLE_NAME, schedule.toContentValues(), where_clause, where_args);
        }

        db.close();
    }

    public int size() {
        SQLiteDatabase db = getReadableDatabase();
        int result = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return result;
    }
}
