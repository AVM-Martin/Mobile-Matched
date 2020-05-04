package id.my.avmmartin.matched.data.network.firestore.model;

import java.util.Calendar;

import id.my.avmmartin.matched.exception.NoTitleException;

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

    public SyncEvent(
            String name,
            String location,
            Calendar startTime,
            Calendar endTime,
            String username
    ) throws NoTitleException {
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

    private void setName(String name) throws NoTitleException {
        if (name.equals("")) {
            throw new NoTitleException();
        } else {
            this.name = name;
        }
    }

    private void setLocation(String location) {
        this.location = location;
    }

    private void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    private void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    private void setCreatorUsersFK(String username) {
        this.creatorUsersFK = username;
    }
}
