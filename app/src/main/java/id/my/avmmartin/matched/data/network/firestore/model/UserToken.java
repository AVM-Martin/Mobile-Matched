package id.my.avmmartin.matched.data.network.firestore.model;

public class UserToken {
    private String username;
    private String deviceId;

    // constructor

    public UserToken() {
        // default constructor
    }

    public UserToken(String username, String deviceId) {
        setUsername(username);
        setDeviceId(deviceId);
    }

    // getter

    public String getUsername() {
        return username;
    }

    public String getDeviceId() {
        return deviceId;
    }

    // setter

    private void setUsername(String username) {
        this.username = username;
    }

    private void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
