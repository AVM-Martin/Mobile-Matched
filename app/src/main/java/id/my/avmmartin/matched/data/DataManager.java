package id.my.avmmartin.matched.data;

import android.content.Context;

import java.util.List;
import java.util.concurrent.ExecutionException;

import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.data.network.firestore.UserTokenManager;
import id.my.avmmartin.matched.data.network.firestore.model.Chat;
import id.my.avmmartin.matched.data.network.firestore.model.PermissionApproval;
import id.my.avmmartin.matched.data.network.firestore.model.User;
import id.my.avmmartin.matched.data.network.firestore.model.UserToken;
import id.my.avmmartin.matched.exception.DataIntegrityException;
import id.my.avmmartin.matched.exception.InvalidCredentialsException;
import id.my.avmmartin.matched.exception.InvalidDurationException;
import id.my.avmmartin.matched.exception.InvalidTokenException;
import id.my.avmmartin.matched.utils.CommonUtils;

public abstract class DataManager {
    // Chat
    public abstract List<User> getChatList();
    public abstract List<Chat> getChatDetails();

    // PermissionApproval
    public abstract PermissionApproval getPermissionApprovalById(String id);
    public abstract List<PermissionApproval> getPendingApproval(String username);
    public abstract List<PermissionApproval> getApprovedApproval(String username);

    // Schedule
    public abstract int sizeByDate(int year, int month, int day);
    public abstract void insertSchedule(Schedule schedule) throws InvalidDurationException;
    public abstract Schedule getScheduleById(int id) throws DataIntegrityException;
    public abstract List<Schedule> getScheduleByDate(int year, int month, int day) throws DataIntegrityException;
    public abstract void updateSchedule(Schedule schedule) throws InvalidDurationException;

    // SyncEvent
    // TODO: network.firestore.SyncEventManager

    // User
    public abstract User getUser(final String username) throws ExecutionException, InterruptedException;

    // UserToken
    public abstract boolean isLoggedIn();
    public abstract void login(String username, String password) throws ExecutionException, InterruptedException, InvalidCredentialsException;
    public abstract String getCurrentUsername() throws ExecutionException, InterruptedException, InvalidTokenException;
    public abstract void logout();

    // helper

    String setUsernameReturnUserToken(String username) {
        UserToken userToken = new UserToken(username, CommonUtils.getDeviceId(context));

        return UserTokenManager.getInstance().setUsernameReturnToken(userToken);
    }

    Boolean isValidUsername(
            final String token,
            String username
    ) throws ExecutionException, InterruptedException, InvalidTokenException {
        final UserToken userToken = new UserToken(username, CommonUtils.getDeviceId(context));

        return UserTokenManager.getInstance().isValidUsername(token, userToken);
    }

    // constructor

    protected Context context;

    DataManager(Context context) {
        this.context = context;
    }
}
