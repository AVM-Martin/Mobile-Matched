package id.my.avmmartin.matched.ui.schedule.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.CalendarView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.utils.CustomCalendar;

public class Activity extends BaseActivity<Presenter> implements MVPView {
    CustomCalendar cvCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_schedule_view);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initComponents() {
        cvCalendar = findViewById(R.id.cvCalendar);
    }

    @Override
    protected void loadData() {
        
    }

    @Override
    protected void setEvents() {

    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }
}
