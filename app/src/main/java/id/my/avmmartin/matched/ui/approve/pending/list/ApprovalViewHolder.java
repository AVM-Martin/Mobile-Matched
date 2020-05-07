package id.my.avmmartin.matched.ui.approve.pending.list;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.components.base.BaseListener;
import id.my.avmmartin.matched.ui.base.BaseViewHolder;

public class ApprovalViewHolder extends BaseViewHolder<Object> {
    public interface Listener extends BaseListener {
        void onCancelScheduleApprovalClick();
        void onAddScheduleApprovalClick();
    }

    private TextView tvUser;
    private TextView tvEventStartDateApproval;
    private TextView tvEventEndDateApproval;
    private ImageButton ibCancelScheduleApproval;
    private ImageButton ibAddScheduleApproval;

    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    // overridden method

    @Override
    protected void initComponents() {
        tvUser = itemView.findViewById(R.id.tvUser);
        tvEventStartDateApproval = itemView.findViewById(R.id.tvEventStartDateApproval);
        tvEventEndDateApproval = itemView.findViewById(R.id.tvEventEndDateApproval);
        ibCancelScheduleApproval = itemView.findViewById(R.id.ibCancelScheduleApproval);
        ibAddScheduleApproval = itemView.findViewById(R.id.ibAddScheduleApproval);
    }

    @Override
    protected void loadData() {
        // TODO: load data
        tvUser.setText("");
        tvEventStartDateApproval.setText("");
        tvEventEndDateApproval.setText("");
    }

    @Override
    protected void setEvents() {
        ibCancelScheduleApproval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCancelScheduleApprovalClick();
            }
        });
        ibAddScheduleApproval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAddScheduleApprovalClick();
            }
        });
    }

    // constructor

    public ApprovalViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
