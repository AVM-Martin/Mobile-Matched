package id.my.avmmartin.matched.exception;

public class EmptyEntryException extends GeneralException {
    public EmptyEntryException(int resId) {
        super("Empty edit text", resId);
    }
}
