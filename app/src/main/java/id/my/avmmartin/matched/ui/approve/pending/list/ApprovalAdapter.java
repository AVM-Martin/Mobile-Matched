package id.my.avmmartin.matched.ui.approve.pending.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.concurrent.ExecutionException;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.components.base.BaseListener;
import id.my.avmmartin.matched.data.DataManager;
import id.my.avmmartin.matched.data.network.firestore.model.PermissionApproval;
import id.my.avmmartin.matched.exception.InvalidTokenException;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BaseRecyclerViewAdapter;

public class ApprovalAdapter extends BaseRecyclerViewAdapter<ApprovalViewHolder> {
    public interface Listener extends BaseListener {
        void onCancelScheduleApprovalClick(String id);
        void onAddScheduleApprovalClick(String id);
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
    public ApprovalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.single_approval_layout, parent, false);

        return new ApprovalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ApprovalViewHolder holder, int position) {
        PermissionApproval data = dataManager.getPendingApproval(username).get(position);

        holder.bindData(data);

        holder.setListener(new ApprovalViewHolder.Listener() {
            @Override
            public void onCancelScheduleApprovalClick(String id) {
                listener.onCancelScheduleApprovalClick(id);
                notifyDataSetChanged();
            }

            @Override
            public void onAddScheduleApprovalClick(String id) {
                listener.onAddScheduleApprovalClick(id);
                notifyDataSetChanged();
            }
        });

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return dataManager.getPendingApproval(username).size();
    }

    // constructor

    private BaseActivity activity;
    private DataManager dataManager;
    private String username;

    public ApprovalAdapter(BaseActivity activity) {
        this.activity = activity;
        this.dataManager = new DataManager(activity);
        this.username = null;
    }
}
