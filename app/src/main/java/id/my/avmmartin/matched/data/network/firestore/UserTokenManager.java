package id.my.avmmartin.matched.data.network.firestore;

import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.ExecutionException;

import id.my.avmmartin.matched.data.network.firestore.model.UserToken;
import id.my.avmmartin.matched.exception.InvalidTokenException;

public class UserTokenManager {
    private static final String TABLE_NAME = "tokens";

    public String setUsernameReturnToken(UserToken userToken) {
        String token = table.document().getId();
        table.document(token).set(userToken);

        return token;
    }

    public boolean validateUsername(String token, UserToken userToken) throws ExecutionException, InterruptedException, InvalidTokenException {
        try {
            UserToken remote = Tasks.await(table.document(token).get()).toObject(UserToken.class);
            return remote.equals(userToken);

        } catch (NullPointerException e) {
            throw new InvalidTokenException();
        }
    }

    public void removeToken(String token) {
        table.document(token).delete();
    }

    // singleton style

    private CollectionReference table;

    private UserTokenManager() {
        this.table = FirebaseFirestore.getInstance().collection(TABLE_NAME);
    }

    public static UserTokenManager getInstance() {
        return new UserTokenManager();
    }
}
