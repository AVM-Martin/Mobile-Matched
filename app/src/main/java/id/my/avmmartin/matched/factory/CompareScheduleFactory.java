package id.my.avmmartin.matched.factory;

import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.exception.InvalidDurationException;
import id.my.avmmartin.matched.exception.NoTitleException;

public class CompareScheduleFactory {
    private List<Schedule> eventLeft = new Vector<>();
    private List<Schedule> eventRight = new Vector<>();

    public static List<Schedule> getEventLeft() {
        return instance.eventLeft;
    }

    public static List<Schedule> getEventRight() {
        return instance.eventRight;
    }

    // creator

    private void createEventLeft() {
        try {
            // first event
            Calendar startA = Calendar.getInstance();
            Calendar endA = Calendar.getInstance();
            startA.set(2020, 5, 7, 7, 0, 0);
            endA.set(2020, 5, 7, 9, 0, 0);
            eventLeft.add(new Schedule("Title", "location", startA, endA));

            // second event
            Calendar startB = Calendar.getInstance();
            Calendar endB = Calendar.getInstance();
            startB.set(2020, 5, 7, 13, 0, 0);
            endB.set(2020, 5, 7, 14, 0, 0);
            eventLeft.add(new Schedule("Title", "location", startB, endB));

            // third event
            Calendar startC = Calendar.getInstance();
            Calendar endC = Calendar.getInstance();
            startC.set(2020, 5, 7, 19, 0, 0);
            endC.set(2020, 5, 7, 21, 0, 0);
            eventLeft.add(new Schedule("Title", "location", startC, endC));

        } catch (NoTitleException e) {
            //
        } catch (InvalidDurationException e) {
            //
        }
    }

    private void createEventRight() {
        try {
            // first event
            Calendar startA = Calendar.getInstance();
            Calendar endA = Calendar.getInstance();
            startA.set(2020, 5, 7, 8, 0, 0);
            endA.set(2020, 5, 7, 10, 0, 0);
            eventRight.add(new Schedule("Title", "location", startA, endA));

            // second event
            Calendar startB = Calendar.getInstance();
            Calendar endB = Calendar.getInstance();
            startB.set(2020, 5, 7, 12, 0, 0);
            endB.set(2020, 5, 7, 14, 0, 0);
            eventRight.add(new Schedule("Title", "location", startB, endB));

            // third event
            Calendar startC = Calendar.getInstance();
            Calendar endC = Calendar.getInstance();
            startC.set(2020, 5, 7, 17, 0, 0);
            endC.set(2020, 5, 7, 18, 0, 0);
            eventRight.add(new Schedule("Title", "location", startC, endC));

        } catch (NoTitleException e) {
            //
        } catch (InvalidDurationException e) {
            //
        }
    }

    // singleton

    private static CompareScheduleFactory instance = new CompareScheduleFactory();

    private CompareScheduleFactory() {
        createEventLeft();
        createEventRight();
    }
}
