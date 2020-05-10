package id.my.avmmartin.matched.data;

import android.content.Context;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import id.my.avmmartin.matched.data.db.ScheduleManager;
import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.data.network.firestore.UserManager;
import id.my.avmmartin.matched.data.network.firestore.UserTokenManager;
import id.my.avmmartin.matched.data.network.firestore.model.Chat;
import id.my.avmmartin.matched.data.network.firestore.model.PermissionApproval;
import id.my.avmmartin.matched.data.network.firestore.model.User;
import id.my.avmmartin.matched.data.network.firestore.model.UserToken;
import id.my.avmmartin.matched.data.prefs.PreferencesHelper;
import id.my.avmmartin.matched.exception.DataIntegrityException;
import id.my.avmmartin.matched.exception.InvalidCredentialsException;
import id.my.avmmartin.matched.exception.InvalidDurationException;
import id.my.avmmartin.matched.exception.InvalidTokenException;
import id.my.avmmartin.matched.factory.ChatFactory;
import id.my.avmmartin.matched.factory.PermissionApprovalFactory;
import id.my.avmmartin.matched.utils.CommonUtils;

public final class DataManager {
    private final Context context;
    private final ScheduleManager scheduleManager;
    private final PreferencesHelper preferencesHelper;

    // Chat

    public List<User> getChatList() {
        // TODO: get online data
        return ChatFactory.getAllChatGroups();
    }

    public List<Chat> getChatDetails() {
        // TODO: get online data
        return ChatFactory.getChatDetails();
    }

    // PermissionApproval

    public PermissionApproval getPermissionApprovalById(String id) {
        // TODO: get online data
        List<PermissionApproval> permissionApprovals = PermissionApprovalFactory.getAllApproval();

        for (PermissionApproval permissionApproval: permissionApprovals) {
            if (permissionApproval.getId().equals(id)) {
                return permissionApproval;
            }
        }

        return null;
    }

    public List<PermissionApproval> getPendingApproval(String username) {
        if (username == null) {
            return new Vector<>();
        }

        // TODO: get online data
        return PermissionApprovalFactory.getPendingApproval();
    }

    public List<PermissionApproval> getApprovedApproval(String username) {
        if (username == null) {
            return new Vector<>();
        }

        // TODO: get online data
        return PermissionApprovalFactory.getApprovedApproval();
    }

    // Schedule

    public int sizeByDate(int year, int month, int day) {
        return scheduleManager.sizeByDate(year, month, day);
    }

    public void insertSchedule(Schedule schedule) throws InvalidDurationException {
        scheduleManager.insertSchedule(schedule);
    }

    public Schedule getScheduleById(int id) throws DataIntegrityException {
        return scheduleManager.getScheduleById(id);
    }

    public List<Schedule> getScheduleByDate(int year, int month, int day) throws DataIntegrityException {
        return scheduleManager.getScheduleByDate(year, month, day);
    }

    public void updateSchedule(Schedule schedule) throws InvalidDurationException {
        scheduleManager.updateSchedule(schedule);
    }

    // SyncEvent

    // TODO: network.firestore.SyncEventManager

    // User

    public User getUser(final String username) throws ExecutionException, InterruptedException {
        return UserManager.getInstance(username).getUser();
    }

    // UserToken

    public void login(String username, String password) throws ExecutionException, InterruptedException, InvalidCredentialsException {
        User user = getUser(username);

        if (!user.isValidPassword(password)) {
            throw new InvalidCredentialsException();
        }

        String token = setUsernameReturnUserToken(username);
        preferencesHelper.setUsername(username);
        preferencesHelper.setUserToken(token);
    }

    public String getCurrentUsername() throws ExecutionException, InterruptedException, InvalidTokenException {
        String username = preferencesHelper.getUsername();

        if (!isValidUsername(preferencesHelper.getUserToken(), username)) {
            throw new InvalidTokenException();
        }

        return username;
    }

    public void logout() {
        UserTokenManager.getInstance().removeToken(preferencesHelper.getUserToken());
        preferencesHelper.setUsername(null);
        preferencesHelper.setUserToken(null);
    }

    // helper

    private String setUsernameReturnUserToken(String username) {
        UserToken userToken = new UserToken(username, CommonUtils.getDeviceId(context));

        return UserTokenManager.getInstance().setUsernameReturnToken(userToken);
    }

    private Boolean isValidUsername(
            final String token,
            String username
    ) throws ExecutionException, InterruptedException, InvalidTokenException {
        final UserToken userToken = new UserToken(username, CommonUtils.getDeviceId(context));

        return UserTokenManager.getInstance().isValidUsername(token, userToken);
    }

    // constructor

    public DataManager(Context context) {
        this.context = context;
        this.scheduleManager = new ScheduleManager(context);
        this.preferencesHelper = new PreferencesHelper(context);
    }
}
