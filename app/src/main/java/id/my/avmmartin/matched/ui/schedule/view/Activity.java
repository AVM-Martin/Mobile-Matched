package id.my.avmmartin.matched.ui.schedule.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.CalendarView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;

public class Activity extends BaseActivity<Presenter> implements MVPView {
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_schedule_view);
        super.onCreate(savedInstanceState);

        calendarView = (CalendarView) findViewById(R.id.calendar);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

            }
        });
    }

    @Override
    protected void initComponents() {

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
