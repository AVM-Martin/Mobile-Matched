package id.my.avmmartin.matched.ui.chat.view.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.concurrent.ExecutionException;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.components.base.BaseListener;
import id.my.avmmartin.matched.data.DataManager;
import id.my.avmmartin.matched.data.network.firestore.model.User;
import id.my.avmmartin.matched.exception.InvalidTokenException;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BaseRecyclerViewAdapter;

public class Adapter extends BaseRecyclerViewAdapter<ViewHolder> {
    public interface Listener extends BaseListener {
        void onClick(String id);
    }

    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void loadUsername() {
        try {
            this.username = dataManager.getCurrentUsername();

        } catch (ExecutionException e) {
            //
        } catch (InterruptedException e) {
            //
        } catch (InvalidTokenException e) {
            //
        }
    }

    // overridden method

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.single_chat_view, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User data = dataManager.getChatList().get(position);

        holder.bindData(data);

        holder.setListener(new ViewHolder.Listener() {
            @Override
            public void onClick(String id) {
                listener.onClick(id);
            }
        });

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return dataManager.getChatList().size();
    }

    // constructor

    private BaseActivity activity;
    private DataManager dataManager;
    private String username;

    public Adapter(BaseActivity activity) {
        this.activity = activity;
        this.dataManager = new DataManager(activity);
        this.username = null;
    }
}
