package id.my.avmmartin.matched.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import id.my.avmmartin.matched.utils.Constants;

public class PreferencesHelper {
    private SharedPreferences sharedPreferences;

    // username

    public String getUsername() {
        return sharedPreferences.getString(Constants.SHARED_PREFS_USERNAME, null);
    }

    public void setUsername(String username) {
        sharedPreferences.edit().putString(Constants.SHARED_PREFS_USERNAME, username).apply();
    }

    // user token

    public String getUserToken() {
        return sharedPreferences.getString(Constants.SHARED_PREFS_USER_TOKEN, null);
    }

    public void setUserToken(String userToken) {
        sharedPreferences.edit().putString(Constants.SHARED_PREFS_USER_TOKEN, userToken).apply();
    }

    // constructor

    public PreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(
            Constants.SHARED_PREFS_FILE_NAME,
            Context.MODE_PRIVATE
        );
    }
}
