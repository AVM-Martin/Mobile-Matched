package id.my.avmmartin.matched.ui.schedule.free;


import android.os.Bundle;
import android.widget.ImageView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;

public class FreeScheduleActivity extends BaseActivity<Presenter> implements MVPView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_free_schedule);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {

        ImageView ivFreeSchedule = findViewById(R.id.ivFreeSchedule);
        ivFreeSchedule.setImageResource(R.drawable.list_selected_24dp);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void setEvents() {

    }

    @Override
    protected void initPresenter() {

    }


}
