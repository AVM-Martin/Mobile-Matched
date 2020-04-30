package id.my.avmmartin.matched.ui.schedule.add;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;

public class AddActivity extends BaseActivity<Presenter> implements MVPView {

    TextView tvStartDate, tvStartTime;
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_add);
        super.onCreate(savedInstanceState);


    }


    @Override
    protected void initComponents() {
        tvStartDate = findViewById(R.id.tvStartDate);
        tvStartTime = findViewById(R.id.tvStartTime);

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


    public void setStartDate(View view) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                SimpleDateFormat df = new SimpleDateFormat("dd MMMM yyyy");
                tvStartDate.setText(df.format(calendar.getTime()));
            }
        },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    public void setStartTime(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(AddActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tvStartTime.setText(hourOfDay + ":" + minute);
            }
        },
            calendar.get(Calendar.HOUR),
            calendar.get(Calendar.MINUTE),
            true
        );

        timePickerDialog.show();
    }
}
