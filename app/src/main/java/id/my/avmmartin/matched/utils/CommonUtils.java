package id.my.avmmartin.matched.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class CommonUtils {
    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();

        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        return progressDialog;
    }

    private CommonUtils() {
        // none
    }
}
