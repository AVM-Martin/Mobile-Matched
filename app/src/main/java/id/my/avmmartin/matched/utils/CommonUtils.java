package id.my.avmmartin.matched.utils;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.provider.Settings;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import id.my.avmmartin.matched.R;

public class CommonUtils {
    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);

        progressDialog.setTitle(context.getString(R.string.load_data));
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        progressDialog.show();

        return progressDialog;
    }

    @SuppressLint("HardwareIds")
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static String toDateFormat(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.US);
        return sdf.format(calendar.getTime());
    }

    public static String toTimeFormat(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.TIME_FORMAT, Locale.US);
        return sdf.format(calendar.getTime());
    }

    public static String toMonthFormat(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.MONTH_FORMAT, Locale.US);
        return sdf.format(calendar.getTime());
    }

    public static int toMinuteFormat(Calendar calendar) {
        return 60 * calendar.get(Calendar.HOUR_OF_DAY) + calendar.get(Calendar.MINUTE);
    }

    private CommonUtils() {
        // none
    }
}
