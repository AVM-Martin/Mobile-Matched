package id.my.avmmartin.matched.factory;

import android.content.Context;

import id.my.avmmartin.matched.data.network.firestore.UserTokenManager;
import id.my.avmmartin.matched.data.network.firestore.model.UserToken;
import id.my.avmmartin.matched.data.prefs.PreferencesHelper;
import id.my.avmmartin.matched.utils.CommonUtils;

public class PreferencesFactory {
    public static void generate(Context context) {
        PreferencesHelper preferencesHelper = new PreferencesHelper(context);

        if (preferencesHelper.getUserToken() == null) {
            UserToken userToken = new UserToken("avm_martin", CommonUtils.getDeviceId(context));

            String token = UserTokenManager.getInstance().setUsernameReturnToken(userToken);
            preferencesHelper.setUsername(userToken.getUsername());
            preferencesHelper.setUserToken(token);
        }
    }
}
