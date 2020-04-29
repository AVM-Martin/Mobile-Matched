package id.my.avmmartin.matched.data;

import android.content.Context;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import id.my.avmmartin.matched.data.db.ScheduleManager;
import id.my.avmmartin.matched.data.network.firestore.UserManager;
import id.my.avmmartin.matched.data.network.firestore.model.User;
import id.my.avmmartin.matched.data.prefs.PreferencesHelper;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.schedule.view.Activity;
import id.my.avmmartin.matched.utils.LoadDataUtils;

public final class DataManager {
    private final BaseActivity baseActivity;
    private final ScheduleManager scheduleManager;
    private final PreferencesHelper preferencesHelper;

    // network.firestore.SyncEventManager

    // TODO: network.firestore.SyncEventManager

    // network.firestore.UserManager

    public User getUser(final String username) throws ExecutionException, InterruptedException {
        LoadDataUtils<User> loadDataUtils = new LoadDataUtils<>(baseActivity);

        loadDataUtils.execute(
            new Callable<User>() {
                @Override
                public User call() throws Exception {
                    return UserManager.getInstance(username).getUser();
                }
            }
        );

        return loadDataUtils.get();
    }

    // constructor

    public DataManager(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
        this.scheduleManager = new ScheduleManager(baseActivity);
        this.preferencesHelper = new PreferencesHelper();
    }
}
