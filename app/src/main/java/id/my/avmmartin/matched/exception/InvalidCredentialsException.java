package id.my.avmmartin.matched.exception;

import id.my.avmmartin.matched.R;

public class InvalidCredentialsException extends GeneralException {
    public InvalidCredentialsException() {
        super("Invalid username password", R.string.warning_not_match_account);
    }
}
