package id.my.avmmartin.matched.data.network.firestore.model;

import java.util.Calendar;

public class SyncEvent {
    private String name;
    private String location;
    private Calendar startTime;
    private Calendar endTime;
    private String creatorUsersFK;

    // constructor

    public SyncEvent() {
        // default constructor
    }

    public SyncEvent(String name, String location, Calendar startTime, Calendar endTime, String username) throws Exception {
        setName(name);
        setLocation(location);
        setStartTime(startTime);
        setEndTime(endTime);
        setCreatorUsersFK(username);
    }

    // getter

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public String getCreatorUsersFK() {
        return creatorUsersFK;
    }

    // setter

    private void setName(String name) throws Exception {
        if (name.equals("")) {
            throw new Exception();
        } else {
            this.name = name;
        }
    }

    private void setLocation(String location) throws Exception {
        this.location = location;
    }

    private void setStartTime(Calendar startTime) throws Exception {
        this.startTime = startTime;
    }

    private void setEndTime(Calendar endTime) throws Exception {
        this.endTime = endTime;
    }

    private void setCreatorUsersFK(String username) throws Exception {
        this.creatorUsersFK = username;
    }
}
