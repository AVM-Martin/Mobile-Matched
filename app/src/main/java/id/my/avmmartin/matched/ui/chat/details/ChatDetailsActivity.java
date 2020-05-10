package id.my.avmmartin.matched.ui.chat.details;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.chat.details.list.Adapter;

public class ChatDetailsActivity extends BaseActivity<Presenter> implements MVPView {
    private RecyclerView rvChatDetails;

    private Adapter adapter;

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_chat_details);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {
        rvChatDetails = findViewById(R.id.rvChatDetails);
    }

    @Override
    protected void loadData() {
        adapter = new Adapter(this, presenter.getDataManager());
        rvChatDetails.setLayoutManager(new LinearLayoutManager(this));
        rvChatDetails.setAdapter(adapter);
    }

    @Override
    protected void setEvents() {
        // none
    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }
}
