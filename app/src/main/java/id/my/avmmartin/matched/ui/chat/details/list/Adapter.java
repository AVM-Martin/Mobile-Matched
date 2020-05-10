package id.my.avmmartin.matched.ui.chat.details.list;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.concurrent.ExecutionException;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.components.base.BaseListener;
import id.my.avmmartin.matched.data.DataManager;
import id.my.avmmartin.matched.data.network.firestore.model.Chat;
import id.my.avmmartin.matched.data.network.firestore.model.PermissionApproval;
import id.my.avmmartin.matched.exception.InvalidTokenException;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BaseRecyclerViewAdapter;

public class Adapter extends BaseRecyclerViewAdapter<ViewHolder> {
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
        View v = LayoutInflater.from(activity).inflate(R.layout.single_chat_details, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Chat data = dataManager.getChatDetails().get(position);

        Log.d("hora", data.getSenderUsersFK());
        holder.bindData(data);

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return dataManager.getChatDetails().size();
    }

    // constructor

    private BaseActivity activity;
    private DataManager dataManager;
    private String username;

    public Adapter(BaseActivity activity, DataManager dataManager) {
        this.activity = activity;
        this.dataManager = dataManager;
        this.username = null;
    }
}
