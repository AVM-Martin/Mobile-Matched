package id.my.avmmartin.matched.exception;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException() {
        super("Invalid username / password");
    }
}
