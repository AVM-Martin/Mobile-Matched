package id.my.avmmartin.matched.ui.chat.view.list;

import android.view.View;
import android.widget.TextView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.components.base.BaseListener;
import id.my.avmmartin.matched.data.network.firestore.model.PermissionApproval;
import id.my.avmmartin.matched.ui.base.BaseViewHolder;
import id.my.avmmartin.matched.utils.CommonUtils;

public class ViewHolder extends BaseViewHolder<PermissionApproval> {
    public interface Listener extends BaseListener {
        void onClick(String id);
    }

    private TextView tvApplicantUser;
    private TextView tvRespondentUser;
    private TextView tvEventDateApproval;

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
    }

    @Override
    protected void loadData() {
        tvApplicantUser.setText(getData().getApplicantUsersFK());
        tvRespondentUser.setText(getData().getRespondentUsersFK());
        tvEventDateApproval.setText(CommonUtils.toDateFormat(getData().getDate()));
    }

    @Override
    protected void setEvents() {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(getData().getId());
            }
        });
    }

    // constructor

    public ViewHolder(View itemView) {
        super(itemView);
    }
}
