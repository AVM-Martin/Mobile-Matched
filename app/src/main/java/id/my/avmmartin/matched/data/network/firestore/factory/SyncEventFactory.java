package id.my.avmmartin.matched.data.network.firestore.factory;

import java.util.Calendar;
import java.util.Random;

import id.my.avmmartin.matched.data.network.firestore.SyncEventManager;
import id.my.avmmartin.matched.data.network.firestore.model.SyncEvent;
import id.my.avmmartin.matched.exception.NoTitleException;

public class SyncEventFactory {
    public static void generate() {
        generateByUsername("avm_martin");
        generateByUsername("ekeitaro");
    }

    private static void generateByUsername(String username) {
        SyncEventManager db = SyncEventManager.getInstance(username);

        Calendar startTime = Calendar.getInstance();
        Calendar endTime = Calendar.getInstance();
        Random rnd = new Random();

        for (int i = 1; i < 50; i++) {
            int month = 3 + rnd.nextInt(2); // April and May
            int day = 1 + rnd.nextInt(30);  // only 1..30
            int hour = rnd.nextInt(24);
            int minute = rnd.nextInt(60);
            int duration = 1 + rnd.nextInt(3);

            startTime.set(2020, month, day, hour, minute, 0);

            endTime.set(2020, month, day, hour, minute, 0);
            endTime.add(Calendar.HOUR_OF_DAY, duration);

            try {
                db.insertEvent(new SyncEvent(
                    "Title " + i,
                    "location",
                    startTime,
                    endTime,
                    username
                ));
            } catch (NoTitleException e) {
                //
            }
        }
    }

    private SyncEventFactory() {
        // none
    }
}
