package id.my.avmmartin.matched.ui.chat.details.list;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.data.network.firestore.model.Chat;
import id.my.avmmartin.matched.ui.base.BaseViewHolder;
import id.my.avmmartin.matched.utils.CommonUtils;

public class ViewHolder extends BaseViewHolder<Chat> {
    private TextView tvSenderUser;
    private TextView tvMessage;
    private TextView tvTimestamp;

    // overridden method

    @Override
    protected void initComponents() {
        tvSenderUser = itemView.findViewById(R.id.tvSenderUser);
        tvMessage = itemView.findViewById(R.id.tvMessage);
        tvTimestamp = itemView.findViewById(R.id.tvTimestamp);
    }

    @Override
    protected void loadData() {
        tvSenderUser.setText(getData().getSenderUsersFK().toUpperCase());
        tvMessage.setText(getData().getMessage());
        tvTimestamp.setText(CommonUtils.toTimeFormat(getData().getTimestamp()));

        if (getData().getSenderUsersFK().equals("avm_martin")) {
            itemView.findViewById(R.id.messageContainer).setRight(0);
            tvSenderUser.setText("ME");
        }
    }

    @Override
    protected void setEvents() {
        // none
    }

    // constructor

    public ViewHolder(View itemView) {
        super(itemView);
    }
}
