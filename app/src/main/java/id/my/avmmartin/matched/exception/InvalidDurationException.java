package id.my.avmmartin.matched.exception;

import id.my.avmmartin.matched.R;

public class InvalidDurationException extends GeneralException {
    public InvalidDurationException() {
        super("Invalid End Time", R.string.warning_invalid_duration);
    }
}
