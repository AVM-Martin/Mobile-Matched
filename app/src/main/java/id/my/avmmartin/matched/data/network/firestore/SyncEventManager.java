package id.my.avmmartin.matched.data.network.firestore;

import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import id.my.avmmartin.matched.data.network.firestore.model.SyncEvent;

public class SyncEventManager {
    private static final String TABLE_NAME = "events";

    private static final String USERNAME = "creatorUsersFK";

    public List<SyncEvent> getEvents() throws ExecutionException, InterruptedException {
        QuerySnapshot task = Tasks.await(table.whereEqualTo(USERNAME, username).get());
        List<SyncEvent> result = new Vector<>();

        for (QueryDocumentSnapshot document : task) {
            result.add(document.toObject(SyncEvent.class));
        }
        return result;
    }

    public void insertEvent(SyncEvent event) {
        table.document().set(event);
    }

    // singleton style

    private CollectionReference table;
    private String username;

    private SyncEventManager(String username) {
        table = FirebaseFirestore.getInstance().collection(TABLE_NAME);
    }

    public static SyncEventManager getInstance(String username) {
        return new SyncEventManager(username);
    }
}
