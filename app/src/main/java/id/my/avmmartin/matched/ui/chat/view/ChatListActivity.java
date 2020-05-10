package id.my.avmmartin.matched.ui.chat.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.chat.details.ChatDetailsActivity;
import id.my.avmmartin.matched.ui.chat.view.list.Adapter;
import id.my.avmmartin.matched.utils.Constants;

public class ChatListActivity extends BaseActivity<Presenter> implements MVPView {
    private RecyclerView rvChatList;

    private Adapter adapter;

    // mvp method

    @Override
    public void onChatClick(String id) {
        Intent intent = new Intent(this, ChatDetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_chat_view);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {
        rvChatList = findViewById(R.id.rvChatList);

        ImageView ivChatList = findViewById(R.id.ivChatList);
        ivChatList.setImageResource(R.drawable.list_selected_24dp);
        ivChatList.setClickable(false);
    }

    @Override
    protected void loadData() {
        adapter = new Adapter(this, presenter.getDataManager());
        rvChatList.setLayoutManager(new LinearLayoutManager(this));
        rvChatList.setAdapter(adapter);
    }

    @Override
    protected void loadOnlineData() {
        adapter.loadUsername();
    }

    @Override
    protected void postLoadOnlineData() {
        super.postLoadOnlineData();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void setEvents() {
        adapter.setListener(new Adapter.Listener() {
            @Override
            public void onClick(String id) {
                onChatClick(id);
            }
        });
    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }
}
