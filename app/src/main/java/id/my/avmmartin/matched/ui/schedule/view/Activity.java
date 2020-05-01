package id.my.avmmartin.matched.ui.schedule.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.recyclerview.widget.RecyclerView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.schedule.add.AddActivity;
import id.my.avmmartin.matched.components.calendar.CustomCalendar;
import id.my.avmmartin.matched.utils.Constants;

public class Activity extends BaseActivity<Presenter> implements MVPView {
    private CustomCalendar cvCalendar;
    private ImageButton ibAddSchedule;
    private RecyclerView rvListSchedule;

    // mvp method

    @Override
    public void addNewScheduleActivity() {
        Intent intent = new Intent(Activity.this, AddActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(Constants.INTENT_SELECTED_DATE, cvCalendar.getSelectedDate().getTimeInMillis());
        startActivity(intent);
    }

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_schedule_view);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        loadData();
        super.onResume();
    }

    @Override
    protected void initComponents() {
        cvCalendar = findViewById(R.id.cvCalendar);
        ibAddSchedule = findViewById(R.id.ibAddSchedule);
        rvListSchedule = findViewById(R.id.rvListSchedule);
    }

    @Override
    protected void loadData() {
        // none
    }

    @Override
    protected void setEvents() {
        ibAddSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewScheduleActivity();
            }
        });
    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }
}
