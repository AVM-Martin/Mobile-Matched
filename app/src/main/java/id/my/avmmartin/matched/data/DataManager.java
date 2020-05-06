package id.my.avmmartin.matched.data;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import id.my.avmmartin.matched.data.db.ScheduleManager;
import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.data.network.firestore.UserManager;
import id.my.avmmartin.matched.data.network.firestore.UserTokenManager;
import id.my.avmmartin.matched.data.network.firestore.model.User;
import id.my.avmmartin.matched.data.network.firestore.model.UserToken;
import id.my.avmmartin.matched.data.prefs.PreferencesHelper;
import id.my.avmmartin.matched.exception.DataIntegrityException;
import id.my.avmmartin.matched.exception.InvalidTokenException;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.utils.CommonUtils;
import id.my.avmmartin.matched.utils.LoadDataUtils;

public final class DataManager {
    private final BaseActivity activity;
    private final ScheduleManager scheduleManager;
    private final PreferencesHelper preferencesHelper;

    // db.ScheduleManager

    public int sizeByDate(int year, int month, int day) {
        return scheduleManager.sizeByDate(year, month, day);
    }

    public void insertSchedule(Schedule schedule) {
        scheduleManager.insertSchedule(schedule);
    }

    public Schedule getScheduleById(int id) throws DataIntegrityException {
        return scheduleManager.getScheduleById(id);
    }

    public List<Schedule> getScheduleByDate(int year, int month, int day) throws DataIntegrityException {
        return scheduleManager.getScheduleByDate(year, month, day);
    }

    // network.firestore.SyncEventManager

    // TODO: network.firestore.SyncEventManager

    // network.firestore.UserManager

    public User getUser(final String username) throws ExecutionException, InterruptedException {
        LoadDataUtils<User> loadDataUtils = new LoadDataUtils<>(activity);

        loadDataUtils.execute(
            new Callable<User>() {
                @Override
                public User call() throws ExecutionException, InterruptedException {
                    return UserManager.getInstance(username).getUser();
                }
            }
        );

        return loadDataUtils.get();
    }

    // network.firestore.UserTokenManager

    public String setUsernameReturnUserToken(String username) throws ExecutionException, InterruptedException {
        final UserToken userToken = new UserToken(username, CommonUtils.getDeviceId(activity));

        LoadDataUtils<String> loadDataUtils = new LoadDataUtils<>(activity);

        loadDataUtils.execute(
            new Callable<String>() {
                @Override
                public String call() throws ExecutionException, InterruptedException {
                    return UserTokenManager.getInstance().setUsernameReturnToken(userToken);
                }
            }
        );

        return loadDataUtils.get();
    }

    public boolean validateUsername(final String token, String username) throws ExecutionException, InterruptedException {
        final UserToken userToken = new UserToken(username, CommonUtils.getDeviceId(activity));

        LoadDataUtils<Boolean> loadDataUtils = new LoadDataUtils<>(activity);

        loadDataUtils.execute(
            new Callable<Boolean>() {
                @Override
                public Boolean call() throws ExecutionException, InterruptedException, InvalidTokenException {
                    return UserTokenManager.getInstance().validateUsername(token, userToken);
                }
            }
        );

        return loadDataUtils.get();
    }

    public void removeToken(String token) {
        UserTokenManager.getInstance().removeToken(token);
    }

    // preferences

    // TODO: preferences
    public void login(String username, String password) {
        //
    }

    public String checkCredentialsReturnUsername() {
        //
        return "";
    }

    public void logout() {
        //
    }

    // constructor

    public DataManager(BaseActivity activity) {
        this.activity = activity;
        this.scheduleManager = new ScheduleManager(activity);
        this.preferencesHelper = new PreferencesHelper(activity);
    }
}
