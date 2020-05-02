package id.my.avmmartin.matched.utils;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.provider.Settings;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

    public static List<Calendar> compareSchedule(List<Calendar> schedules1, List<Calendar> schedules2) {
        List<Calendar> listFreeSchedules = new ArrayList<>();

        return listFreeSchedules;
    }

    private CommonUtils() {
        // none
    }
}
