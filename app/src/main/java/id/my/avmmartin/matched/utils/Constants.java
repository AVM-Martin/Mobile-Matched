package id.my.avmmartin.matched.utils;

public class Constants {
    public static final String PACKAGE_NAME = "id.my.avmmartin.matched";

    public static final String DB_NAME = "MatchedDB";

    public static final int NEW_SCHEDULE_ID = -1;

    public static final String DATE_FORMAT = "dd MM yyyy";
    public static final String TIME_FORMAT = "HH:mm";
    public static final String MONTH_FORMAT = "yyyy MMMM";

    public static final String INTENT_SELECTED_DATE = PACKAGE_NAME + ".SELECTED_DATE";
    public static final String INTENT_SELECTED_SCHEDULE_ID = PACKAGE_NAME + ".SELECTED_SCHEDULE_ID";
    public static final String INTENT_SELECTED_APPROVAL_ID = PACKAGE_NAME + ".SELECTED_APPROVAL_ID";

    public static final String SHARED_PREFS_FILE_NAME = "MatchedSharedPrefs";
    public static final String SHARED_PREFS_USER_TOKEN = PACKAGE_NAME + ".USER_TOKEN";
    public static final String SHARED_PREFS_USERNAME = PACKAGE_NAME + ".USERNAME";

    private Constants() {
        // none
    }
}
