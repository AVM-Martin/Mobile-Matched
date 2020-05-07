package id.my.avmmartin.matched.ui.approve.pending.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.components.base.BaseListener;
import id.my.avmmartin.matched.data.DataManager;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BaseRecyclerViewAdapter;

public class ApprovalAdapter extends BaseRecyclerViewAdapter<ApprovalViewHolder> {
    public interface Listener extends BaseListener {
        void onCancelScheduleApprovalClick();
        void onAddScheduleApprovalClick();
    }

    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
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
        // TODO: get data
        // holder.bindData(data);

        holder.setListener(new ApprovalViewHolder.Listener() {
            @Override
            public void onCancelScheduleApprovalClick() {
                listener.onCancelScheduleApprovalClick();
                notifyDataSetChanged();
            }

            @Override
            public void onAddScheduleApprovalClick() {
                listener.onAddScheduleApprovalClick();
                notifyDataSetChanged();
            }
        });

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // constructor

    private BaseActivity activity;
    private DataManager dataManager;

    public ApprovalAdapter(BaseActivity activity) {
        this.activity = activity;
        this.dataManager = new DataManager(activity);
    }
}
