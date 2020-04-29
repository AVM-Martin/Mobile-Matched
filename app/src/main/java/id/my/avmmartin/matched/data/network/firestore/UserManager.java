package id.my.avmmartin.matched.data.network.firestore;

import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import id.my.avmmartin.matched.data.network.firestore.model.User;

public class UserManager {
    private static final String TABLE_NAME = "users";

    public User getUser() throws Exception {
        return Tasks.await(tableRow.get()).toObject(User.class);
    }

    public void setUser(User user) {
        tableRow.set(user);
    }

    // singleton style

    private DocumentReference tableRow;

    private UserManager(String username) {
        CollectionReference table = FirebaseFirestore.getInstance().collection(TABLE_NAME);
        tableRow = table.document(username);
    }

    public static UserManager getInstance(String username) {
        return new UserManager(username);
    }
}
