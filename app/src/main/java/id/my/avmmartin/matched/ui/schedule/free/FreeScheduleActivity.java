package id.my.avmmartin.matched.ui.schedule.free;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.schedule.free.list.Adapter;

public class FreeScheduleActivity extends BaseActivity<Presenter> implements MVPView {
    private RecyclerView rvListSchedule;

    private Adapter adapter;

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_schedule_free);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {
        rvListSchedule = findViewById(R.id.rvListSchedule);

        ImageView ivFreeSchedule = findViewById(R.id.ivFreeSchedule);
        ivFreeSchedule.setImageResource(R.drawable.list_selected_24dp);
    }

    @Override
    protected void loadData() {
        adapter = new Adapter(this, presenter.getFreeScheduleList());
        rvListSchedule.setLayoutManager(new LinearLayoutManager(this));
        rvListSchedule.setAdapter(adapter);
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
