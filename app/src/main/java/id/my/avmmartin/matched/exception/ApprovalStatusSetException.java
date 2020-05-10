package id.my.avmmartin.matched.exception;

import id.my.avmmartin.matched.R;

public class ApprovalStatusSetException extends GeneralException {
    public ApprovalStatusSetException() {
        super("Approval has been set before", R.string.error_duplicate_approval);
    }
}
