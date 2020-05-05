package id.my.avmmartin.matched;

import android.app.Application;

import id.my.avmmartin.matched.data.db.factory.ScheduleFactory;

public final class Matched extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // TODO: remove this line before production phase
        ScheduleFactory.generate(getApplicationContext());
    }
}
