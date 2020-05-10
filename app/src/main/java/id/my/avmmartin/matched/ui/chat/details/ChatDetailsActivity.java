package id.my.avmmartin.matched.ui.chat.details;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.chat.details.list.Adapter;

public class ChatDetailsActivity extends BaseActivity<Presenter> implements MVPView {
    private RecyclerView rvChatDetails;
    private EditText etNewMessage;
    private Button btnSendMessage;

    private Adapter adapter;

    // mvp method

    @Override
    public void sendMessage() {
        presenter.sendMessage(etNewMessage.getText().toString());
        etNewMessage.setText("");

        adapter.notifyDataSetChanged();
    }

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_chat_details);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {
        rvChatDetails = findViewById(R.id.rvChatDetails);
        etNewMessage = findViewById(R.id.etNewMessage);
        btnSendMessage = findViewById(R.id.btnSendMessage);
    }

    @Override
    protected void loadData() {
        etNewMessage.setText("");

        adapter = new Adapter(this, presenter.getDataManager());
        rvChatDetails.setLayoutManager(new LinearLayoutManager(this));
        rvChatDetails.setAdapter(adapter);
    }

    @Override
    protected void setEvents() {
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }
}
