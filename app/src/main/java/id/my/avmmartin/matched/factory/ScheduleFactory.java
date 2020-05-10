package id.my.avmmartin.matched.factory;

import android.content.Context;

import java.util.Calendar;
import java.util.Random;

import id.my.avmmartin.matched.data.db.ScheduleManager;
import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.exception.InvalidDurationException;
import id.my.avmmartin.matched.exception.NoTitleException;

public class ScheduleFactory {
    public static void generate(Context context) {
        ScheduleManager db = new ScheduleManager(context);

        if (db.size() == 0) {
            Calendar startTime = Calendar.getInstance();
            Calendar endTime = Calendar.getInstance();
            Random rnd = new Random();

            for (int i = 1; i < 50; i++) {
                int month = 3 + rnd.nextInt(2); // April and May
                int day = 1 + rnd.nextInt(30);  // only 1..30
                int hour = rnd.nextInt(24);
                int minute = 30 * rnd.nextInt(2);
                int duration = 1 + rnd.nextInt(3);

                startTime.set(2020, month, day, hour, minute, 0);

                endTime.set(2020, month, day, hour, minute, 0);
                endTime.add(Calendar.HOUR_OF_DAY, duration);

                try {
                    db.insertSchedule(new Schedule(
                        "Title " + i,
                        "location",
                        startTime,
                        endTime
                    ));
                } catch (NoTitleException e) {
                    //
                } catch (InvalidDurationException e) {
                    //
                }
            }
        }
    }
}
