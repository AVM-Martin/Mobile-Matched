package id.my.avmmartin.matched.ui.approve.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.approve.view.list.Adapter;
import id.my.avmmartin.matched.ui.schedule.free.FreeScheduleActivity;
import id.my.avmmartin.matched.utils.Constants;

public class ApprovedActivity extends BaseActivity<Presenter> implements MVPView {
    private RecyclerView rvListApproval;

    private Adapter adapter;

    // mvp method

    @Override
    public void onApprovedItemClick(String id) {
        Intent intent = new Intent(this, FreeScheduleActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.putExtra(Constants.INTENT_SELECTED_APPROVAL_ID, id);
        startActivity(intent);
    }

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_approval_view);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {
        rvListApproval = findViewById(R.id.rvListApproval);

        ImageView ivFreeSchedule = findViewById(R.id.ivFreeSchedule);
        ivFreeSchedule.setImageResource(R.drawable.list_selected_24dp);
        ivFreeSchedule.setClickable(false);
    }

    @Override
    protected void loadData() {
        adapter = new Adapter(this);
        rvListApproval.setLayoutManager(new LinearLayoutManager(this));
        rvListApproval.setAdapter(adapter);
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
                onApprovedItemClick(id);
            }
        });
    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }
}
