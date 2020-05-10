package id.my.avmmartin.matched.ui.chat.view.list;

import android.view.View;
import android.widget.TextView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.components.base.BaseListener;
import id.my.avmmartin.matched.data.network.firestore.model.User;
import id.my.avmmartin.matched.ui.base.BaseViewHolder;

public class ViewHolder extends BaseViewHolder<User> {
    public interface Listener extends BaseListener {
        void onClick(String id);
    }

    private TextView tvSenderUser;

    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    // overridden method

    @Override
    protected void initComponents() {
        tvSenderUser = itemView.findViewById(R.id.tvSenderUser);
    }

    @Override
    protected void loadData() {
        tvSenderUser.setText(getData().getName());
    }

    @Override
    protected void setEvents() {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(getData().getName());
            }
        });
    }

    // constructor

    public ViewHolder(View itemView) {
        super(itemView);
    }
}
