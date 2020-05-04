package id.my.avmmartin.matched.ui.schedule.add;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.data.db.ScheduleManager;
import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.schedule.view.Activity;
import id.my.avmmartin.matched.utils.CommonUtils;
import id.my.avmmartin.matched.utils.Constants;

public class AddActivity extends BaseActivity<Presenter> implements MVPView, View.OnClickListener {

    EditText etEventName, etEventLocation;
    TextView tvEventStartDate, tvEventStartTime;
    TextView tvEventEndDate, tvEventEndTime;
    ImageButton ibCancelSchedule, ibAddSchedule;
    Calendar startTime = Calendar.getInstance();
    Calendar endTime = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_add);
        super.onCreate(savedInstanceState);



    }


    @Override
    protected void initComponents() {
        Intent intent = getIntent();
        startTime.setTimeInMillis(intent.getLongExtra(Constants.INTENT_SELECTED_DATE, 0));
        endTime.setTimeInMillis(intent.getLongExtra(Constants.INTENT_SELECTED_DATE, 0));


        etEventName = findViewById(R.id.etEventName);
        etEventLocation = findViewById(R.id.etEventLocation);

        tvEventStartDate = findViewById(R.id.tvEventStartDate);
        tvEventStartTime = findViewById(R.id.tvEventStartTime);

        tvEventStartDate.setText(CommonUtils.toDateFormat(startTime));
        tvEventStartTime.setText(CommonUtils.toTimeFormat(startTime));

        tvEventEndDate = findViewById(R.id.tvEventEndDate);
        tvEventEndTime = findViewById(R.id.tvEventEndTime);
        tvEventEndDate.setText(CommonUtils.toDateFormat(endTime));
        tvEventEndTime.setText(CommonUtils.toTimeFormat(endTime));

        ibAddSchedule = findViewById(R.id.ibAddSchedule);
        ibCancelSchedule = findViewById(R.id.ibCancelSchedule);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void setEvents() {
        ibCancelSchedule.setOnClickListener(this);
        ibAddSchedule.setOnClickListener(this);
    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }


    public void setDate(View view, final Calendar calendar, final TextView fill) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                fill.setText(CommonUtils.toDateFormat(calendar));
            }
        },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    public void setTime(View view, final Calendar calendar, final TextView fill) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(AddActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                fill.setText(CommonUtils.toTimeFormat(calendar));
            }
        },
            calendar.get(Calendar.HOUR),
            calendar.get(Calendar.MINUTE),
            true
        );

        timePickerDialog.show();
    }

    public void setStartDate(View view) {
        setDate(view, startTime, tvEventStartDate);
    }

    public void setStartTime(View view) {
        setTime(view, startTime, tvEventStartTime);
    }

    public void setEndDate(View view) {
        setDate(view, endTime, tvEventEndDate);
    }

    public void setEndTime(View view) {
        setTime(view, endTime, tvEventEndTime);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == ibAddSchedule.getId()) {
            try {
                Schedule schedule = new Schedule(etEventName.getText().toString(), etEventLocation.getText().toString(), startTime, endTime);
                ScheduleManager scheduleManager = new ScheduleManager(this);
                scheduleManager.insertSchedule(schedule);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(v.getId() == ibCancelSchedule.getId()) {

        }
        Intent intent = new Intent(this, Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }
}
