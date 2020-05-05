package id.my.avmmartin.matched.ui.schedule.free;

import android.os.Bundle;
import android.widget.ImageView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;

public class FreeScheduleActivity extends BaseActivity<Presenter> implements MVPView {
    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_schedule_free);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {
        // none

        ImageView ivFreeSchedule = findViewById(R.id.ivFreeSchedule);
        ivFreeSchedule.setImageResource(R.drawable.list_selected_24dp);
    }

    @Override
    protected void loadData() {
        // none
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
