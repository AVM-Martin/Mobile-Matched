package id.my.avmmartin.matched.data.network.firestore.factory;

import id.my.avmmartin.matched.data.network.firestore.UserManager;
import id.my.avmmartin.matched.data.network.firestore.model.User;

public class UserFactory {
    public static void generate() {
        UserManager.getInstance("avm_martin").setUser(new User("AVM", "martin"));
        UserManager.getInstance("ekeitaro").setUser(new User("ekei", "taro"));
    }

    private UserFactory() {
        // none
    }
}
