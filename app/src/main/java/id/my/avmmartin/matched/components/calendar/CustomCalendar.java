package id.my.avmmartin.matched.components.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.data.db.model.Schedule;

public class CustomCalendar extends LinearLayout {
    private static int MAX_CALENDAR_DAYS = 42;

    ImageButton ibPreviousMonth, ibNextMonth;
    TextView tvCurrentMonth;
    GridView gvDates;
    Calendar calendar = Calendar.getInstance();
    Context context;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MMMM");

    CalendarAdapter calendarAdapter;

    List<Date> dates = new ArrayList<>();
    List<Schedule> schedules = new ArrayList<>();

    public CustomCalendar(Context context) {
        super(context);
    }

    public CustomCalendar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initializeLayout();


        ibPreviousMonth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.MONTH, -1);
                setCalendar();
            }
        });

        ibNextMonth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.MONTH, 1);
                setCalendar();
            }
        });

        gvDates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Date selectedDate = calendarAdapter.dates.get(position);
                Toast.makeText(getContext(), String.valueOf(selectedDate), Toast.LENGTH_LONG).show();
//                ((CalendarAdapter) parent.getAdapter()).getPosition(selectedDate, getContext().);
            }
        });


    }

    public CustomCalendar(Context context, AttributeSet attrs, int defStyleAttr, Context context1) {
        super(context, attrs, defStyleAttr);
        this.context = context1;
    }

    private void initializeLayout() {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.calendar_layout, this);
        ibPreviousMonth = view.findViewById(R.id.ibPreviousMonth);
        ibNextMonth = view.findViewById(R.id.ibNextMonth);
        tvCurrentMonth = view.findViewById(R.id.tvCurrentMonth);
        gvDates = view.findViewById(R.id.gvDates);

        setCalendar();
    }

    private void setCalendar() {
        String currentMonth = simpleDateFormat.format(calendar.getTime());
        tvCurrentMonth.setText(currentMonth);

        dates.clear();
        Calendar monthCalendar = (Calendar) calendar.clone();
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfMonth = monthCalendar.get(Calendar.DAY_OF_WEEK)-1;
        monthCalendar.add(Calendar.DAY_OF_MONTH, -firstDayOfMonth);

        if(firstDayOfMonth + calendar.getActualMaximum(Calendar.DAY_OF_MONTH) < 36) MAX_CALENDAR_DAYS = 35;
        else MAX_CALENDAR_DAYS = 42;

        while(dates.size() < MAX_CALENDAR_DAYS) {
            dates.add(monthCalendar.getTime());
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        calendarAdapter = new CalendarAdapter(context, dates, calendar, schedules);
        gvDates.setAdapter(calendarAdapter);
    }

}
