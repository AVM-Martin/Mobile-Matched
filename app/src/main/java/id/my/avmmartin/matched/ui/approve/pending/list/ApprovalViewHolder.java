package id.my.avmmartin.matched.ui.approve.pending.list;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.components.base.BaseListener;
import id.my.avmmartin.matched.data.network.firestore.model.PermissionApproval;
import id.my.avmmartin.matched.ui.base.BaseViewHolder;
import id.my.avmmartin.matched.utils.CommonUtils;

public class ApprovalViewHolder extends BaseViewHolder<PermissionApproval> {
    public interface Listener extends BaseListener {
        void onCancelScheduleApprovalClick(String id);
        void onAddScheduleApprovalClick(String id);
    }

    private TextView tvApplicantUser;
    private TextView tvRespondentUser;
    private TextView tvEventDateApproval;
    private ImageButton ibCancelScheduleApproval;
    private ImageButton ibAddScheduleApproval;

    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    // overridden method

    @Override
    protected void initComponents() {
        tvApplicantUser = itemView.findViewById(R.id.tvApplicantUser);
        tvRespondentUser = itemView.findViewById(R.id.tvRespondentUser);
        tvEventDateApproval = itemView.findViewById(R.id.tvEventDateApproval);
        ibCancelScheduleApproval = itemView.findViewById(R.id.ibCancelScheduleApproval);
        ibAddScheduleApproval = itemView.findViewById(R.id.ibAddScheduleApproval);
    }

    @Override
    protected void loadData() {
        tvApplicantUser.setText(getData().getApplicantUsersFK());
        tvRespondentUser.setText(getData().getRespondentUsersFK());
        tvEventDateApproval.setText(CommonUtils.toDateFormat(getData().getDate()));
    }

    @Override
    protected void setEvents() {
        ibCancelScheduleApproval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCancelScheduleApprovalClick(getData().getId());
            }
        });
        ibAddScheduleApproval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAddScheduleApprovalClick(getData().getId());
            }
        });
    }

    // constructor

    public ApprovalViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
