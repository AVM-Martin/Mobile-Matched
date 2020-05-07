package id.my.avmmartin.matched.data.network.firestore.model;

import java.util.Calendar;

import id.my.avmmartin.matched.exception.ApprovalStatusSetException;

public class PermissionApproval {
    private static final int STATUS_REJECTED = -1;
    private static final int STATUS_WAITING = 0;
    private static final int STATUS_APPROVED = 1;

    private String id;
    private Calendar date;
    private String applicantUsersFK;
    private String respondentUsersFK;
    private int status;

    public void approve() throws ApprovalStatusSetException {
        if (getStatus() != STATUS_WAITING) {
            throw new ApprovalStatusSetException();
        } else {
            this.status = STATUS_APPROVED;
        }
    }

    public void reject() throws ApprovalStatusSetException {
        if (getStatus() != STATUS_WAITING) {
            throw new ApprovalStatusSetException();
        } else {
            this.status = STATUS_REJECTED;
        }
    }

    // constructor

    public PermissionApproval() {
        // default constructor
    }

    public PermissionApproval(
        Calendar date,
        String applicantUsersFK,
        String respondentUsersFK
    ) {
        setDate(date);
        setApplicantUsersFK(applicantUsersFK);
        setRespondentUsersFK(respondentUsersFK);
        this.status = STATUS_WAITING;
    }

    // getter

    public String getId() {
        return id;
    }

    public Calendar getDate() {
        return date;
    }

    public String getApplicantUsersFK() {
        return applicantUsersFK;
    }

    public String getRespondentUsersFK() {
        return respondentUsersFK;
    }

    public int getStatus() {
        return status;
    }

    // setter

    public void setId(String id) {
        this.id = id;
    }

    private void setDate(Calendar date) {
        this.date = date;
    }

    private void setApplicantUsersFK(String applicantUsersFK) {
        this.applicantUsersFK = applicantUsersFK;
    }

    private void setRespondentUsersFK(String respondentUsersFK) {
        this.respondentUsersFK = respondentUsersFK;
    }
}
