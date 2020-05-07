package id.my.avmmartin.matched.ui.schedule.free;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.schedule.free.list.Adapter;
import id.my.avmmartin.matched.utils.Constants;

public class FreeScheduleActivity extends BaseActivity<Presenter> implements MVPView {
    private RecyclerView rvListSchedule;

    private Adapter adapter;
    private String approvalId;

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_schedule_free);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {
        rvListSchedule = findViewById(R.id.rvListSchedule);
        approvalId = getIntent().getStringExtra(Constants.INTENT_SELECTED_APPROVAL_ID);
    }

    @Override
    protected void loadData() {
        adapter = new Adapter(this);
        rvListSchedule.setLayoutManager(new LinearLayoutManager(this));
        rvListSchedule.setAdapter(adapter);
    }

    @Override
    protected void loadOnlineData() {
        adapter.setSchedules(presenter.getFreeScheduleList(approvalId));
    }

    @Override
    protected void postLoadOnlineData() {
        super.postLoadOnlineData();
        adapter.notifyDataSetChanged();
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
