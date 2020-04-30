package id.my.avmmartin.matched.utils;

import android.app.ProgressDialog;
import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CommonUtils {
    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();

        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        return progressDialog;
    }

    public static String toDateFormat(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.US);
        return sdf.format(calendar.getTime());
    }

    public static String toTimeFormat(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.TIME_FORMAT, Locale.US);
        return sdf.format(calendar.getTime());
    }

    private CommonUtils() {
        // none
    }
}
