package id.my.avmmartin.matched.exception;

import id.my.avmmartin.matched.R;

public class GeneralException extends Exception {
    private int resId;

    public int getErrorId() {
        return resId;
    }

    // constructor

    public GeneralException(String message) {
        super(message);
        this.resId = R.string.error_general;
    }

    public GeneralException(String message, int resId) {
        super(message);
        this.resId = resId;
    }
}
