package id.my.avmmartin.matched.exception;

public class ApprovalStatusSetException extends Exception {
    public ApprovalStatusSetException() {
        super("Approval has been set before");
    }
}
