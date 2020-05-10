package id.my.avmmartin.matched.data.network.firestore.model;

import java.util.Calendar;

public class Chat {
    private static final int STATUS_FAILED = -1;
    private static final int STATUS_SENDING = 0;
    private static final int STATUS_SENT = 1;
    private static final int STATUS_DELIVERED = 2;
    private static final int STATUS_READ = 3;

    private String id;
    private Calendar timestamp;
    private String message;
    private String senderUsersFK;
    private String receiverUsersFK;
    private int status;

    // constructor

    public Chat() {
        // default constructor
    }

    public Chat(String message, String senderUsersFK, String receiverUsersFK) {
        setTimestamp(Calendar.getInstance());
        setMessage(message);
        setSenderUsersFK(senderUsersFK);
        setReceiverUsersFK(receiverUsersFK);
        this.status = STATUS_SENDING;
    }

    // getter

    public String getId() {
        return id;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getSenderUsersFK() {
        return senderUsersFK;
    }

    public String getReceiverUsersFK() {
        return receiverUsersFK;
    }

    public int getStatus() {
        return status;
    }

    // setter

    public void setId(String id) {
        this.id = id;
    }

    private void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    private void setSenderUsersFK(String senderUsersFK) {
        this.senderUsersFK = senderUsersFK;
    }

    private void setReceiverUsersFK(String receiverUsersFK) {
        this.receiverUsersFK = receiverUsersFK;
    }

    private void setStatus(int status) {
        this.status = status;
    }
}
