package id.my.avmmartin.matched.ui.schedule.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.components.calendar.CustomCalendar;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.schedule.add.AddActivity;
import id.my.avmmartin.matched.ui.schedule.view.list.Adapter;
import id.my.avmmartin.matched.utils.Constants;

public class Activity extends BaseActivity<Presenter> implements MVPView {
    private CustomCalendar cvCalendar;
    private ImageButton ibAddSchedule;
    private RecyclerView rvListSchedule;

    private Adapter adapter;

    // mvp method

    @Override
    public void addNewScheduleActivity() {
        Intent intent = new Intent(Activity.this, AddActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.putExtra(Constants.INTENT_SELECTED_DATE, getSelectedDate().getTimeInMillis());
        startActivity(intent);
    }

    @Override
    public Calendar getSelectedDate() {
        return cvCalendar.getSelectedDate();
    }

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_schedule_view);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        cvCalendar.notifyDataSetChanged();
        adapter.notifyDataSetChanged();
        super.onResume();
    }

    @Override
    protected void initComponents() {
        cvCalendar = findViewById(R.id.cvCalendar);
        ibAddSchedule = findViewById(R.id.ibAddSchedule);
        rvListSchedule = findViewById(R.id.rvListSchedule);

        ImageView ivHome = findViewById(R.id.ivHome);
        ivHome.setImageResource(R.drawable.home_selected_24dp);
        ivHome.setClickable(false);
    }

    @Override
    protected void loadData() {
        adapter = new Adapter(this);
        rvListSchedule.setLayoutManager(new LinearLayoutManager(this));
        rvListSchedule.setAdapter(adapter);
    }

    @Override
    protected void setEvents() {
        cvCalendar.setListener(new CustomCalendar.Listener() {
            @Override
            public void onDateClick() {
                adapter.notifyDataSetChanged();
            }
        });
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
