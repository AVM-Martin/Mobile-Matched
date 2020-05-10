package id.my.avmmartin.matched.exception;

import id.my.avmmartin.matched.R;

public class NoTitleException extends GeneralException {
    public NoTitleException() {
        super("Please insert title", R.string.warning_empty_title);
    }
}
