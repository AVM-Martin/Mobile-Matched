package id.my.avmmartin.matched.data;

import android.content.Context;

import java.util.List;
import java.util.concurrent.ExecutionException;

import id.my.avmmartin.matched.data.db.ScheduleManager;
import id.my.avmmartin.matched.data.db.model.Schedule;
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

public final class ProtoManager extends DataManager {
    private static final String USERNAME = "guest";
    private static final String PASSWORD = "guest";
    private static final String TOKEN = "temporaryToken";

    private final ScheduleManager scheduleManager;
    private final PreferencesHelper preferencesHelper;

    // Chat

    @Override
    public List<User> getChatList() {
        return ChatFactory.getAllChatGroups();
    }

    @Override
    public List<Chat> getChatDetails() {
        return ChatFactory.getChatDetails();
    }

    // PermissionApproval

    @Override
    public PermissionApproval getPermissionApprovalById(String id) {
        List<PermissionApproval> permissionApprovals = PermissionApprovalFactory.getAllApproval();

        for (PermissionApproval permissionApproval: permissionApprovals) {
            if (permissionApproval.getId().equals(id)) {
                return permissionApproval;
            }
        }

        return null;
    }

    @Override
    public List<PermissionApproval> getPendingApproval(String username) {
        return PermissionApprovalFactory.getPendingApproval();
    }

    @Override
    public List<PermissionApproval> getApprovedApproval(String username) {
        return PermissionApprovalFactory.getApprovedApproval();
    }

    // Schedule

    @Override
    public int sizeByDate(int year, int month, int day) {
        return scheduleManager.sizeByDate(year, month, day);
    }

    @Override
    public void insertSchedule(Schedule schedule) throws InvalidDurationException {
        scheduleManager.insertSchedule(schedule);
    }

    @Override
    public Schedule getScheduleById(int id) throws DataIntegrityException {
        return scheduleManager.getScheduleById(id);
    }

    @Override
    public List<Schedule> getScheduleByDate(int year, int month, int day) throws DataIntegrityException {
        return scheduleManager.getScheduleByDate(year, month, day);
    }

    @Override
    public void updateSchedule(Schedule schedule) throws InvalidDurationException {
        scheduleManager.updateSchedule(schedule);
    }

    // SyncEvent

    // TODO: network.firestore.SyncEventManager

    // User

    @Override
    public User getUser(final String username) throws ExecutionException, InterruptedException {
        return new User(USERNAME, PASSWORD);
    }

    // UserToken

    @Override
    public void login(String username, String password) throws ExecutionException, InterruptedException, InvalidCredentialsException {
        User user = getUser(username);

        if (!user.isValidPassword(password)) {
            throw new InvalidCredentialsException();
        }

        String token = setUsernameReturnUserToken(username);
        preferencesHelper.setUsername(username);
        preferencesHelper.setUserToken(token);
    }

    @Override
    public String getCurrentUsername() throws ExecutionException, InterruptedException, InvalidTokenException {
        String username = preferencesHelper.getUsername();

        if (!isValidUsername(preferencesHelper.getUserToken(), username)) {
            throw new InvalidTokenException();
        }

        return username;
    }

    @Override
    public void logout() {
        preferencesHelper.setUsername(null);
        preferencesHelper.setUserToken(null);
    }

    // helper

    @Override
    String setUsernameReturnUserToken(String username) {
        UserToken userToken = new UserToken(username, CommonUtils.getDeviceId(context));
        UserTokenManager.getInstance().setUsernameReturnToken(userToken);

        return TOKEN;
    }

    @Override
    Boolean isValidUsername(
        final String token,
        String username
    ) throws ExecutionException, InterruptedException, InvalidTokenException {
        if (!TOKEN.equals(token)) {
            throw new InvalidTokenException();
        }

        return USERNAME.equals(username);
    }

    // constructor

    public ProtoManager(Context context) {
        super(context);

        this.scheduleManager = new ScheduleManager(context);
        this.preferencesHelper = new PreferencesHelper(context);
    }
}
