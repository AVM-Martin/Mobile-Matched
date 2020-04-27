package id.my.avmmartin.matched.data;

import android.content.Context;

import id.my.avmmartin.matched.data.db.ScheduleManager;
import id.my.avmmartin.matched.data.prefs.PreferencesHelper;

public final class DataManager {
    private final Context context;
    private final ScheduleManager scheduleManager;
    private final PreferencesHelper preferencesHelper;

    public DataManager(Context context) {
        this.context = context;
        this.scheduleManager = new ScheduleManager(context);
        this.preferencesHelper = new PreferencesHelper();
    }
}
