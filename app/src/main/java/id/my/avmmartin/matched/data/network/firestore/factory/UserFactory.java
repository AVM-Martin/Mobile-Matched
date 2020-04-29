package id.my.avmmartin.matched.data.network.firestore.factory;

import id.my.avmmartin.matched.data.network.firestore.UserManager;
import id.my.avmmartin.matched.data.network.firestore.model.User;
import id.my.avmmartin.matched.ui.base.BaseActivity;

public class UserFactory {
    public static void generate() throws Exception {
        UserManager.getInstance("avm_martin").setUser(new User("AVM", "martin"));
        UserManager.getInstance("ekeitaro").setUser(new User("ekei", "taro"));
    }

    private UserFactory() {
        // none
    }
}
