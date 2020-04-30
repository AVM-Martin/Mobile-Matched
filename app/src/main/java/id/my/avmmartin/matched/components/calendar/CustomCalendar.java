package id.my.avmmartin.matched.components.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.components.base.BaseLinearLayout;
import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.utils.CommonUtils;

public class CustomCalendar extends BaseLinearLayout implements MVPView {
    private static final int MAX_CALENDAR_DAYS = 42;

    private ImageButton ibPreviousMonth;
    private ImageButton ibNextMonth;
    private TextView tvCurrentMonth;
    private GridView gvDates;

    private CalendarAdapter calendarAdapter;
    private Calendar selectedDate;

    public Calendar getSelectedDate() {
        return selectedDate;
    }

    // mvp method

    @Override
    public void showPrevMonth() {
        selectedDate.add(Calendar.MONTH, -1);
        loadDatas();
    }

    @Override
    public void showNextMonth() {
        selectedDate.add(Calendar.MONTH, 1);
        loadDatas();
    }

    @Override
    public void selectDateAndLoadCalendar(int position) {
        selectedDate = (Calendar) calendarAdapter.getItem(position);
        loadDatas();
    }

    // overridden method

    @Override
    protected void initComponents() {
        Context context = getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.calendar_layout, this);

        ibPreviousMonth = view.findViewById(R.id.ibPreviousMonth);
        ibNextMonth = view.findViewById(R.id.ibNextMonth);
        tvCurrentMonth = view.findViewById(R.id.tvCurrentMonth);
        gvDates = view.findViewById(R.id.gvDates);

        selectedDate = Calendar.getInstance();
    }

    @Override
    protected void loadDatas() {
        tvCurrentMonth.setText(CommonUtils.toMonthFormat(selectedDate));

        Calendar monthCalendar = (Calendar) selectedDate.clone();
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1);

        int firstDayOfMonth = monthCalendar.get(Calendar.DAY_OF_WEEK) - 1;
        monthCalendar.add(Calendar.DAY_OF_MONTH, -firstDayOfMonth);

        int MAX_DAYS = MAX_CALENDAR_DAYS;
        if (firstDayOfMonth + selectedDate.getActualMaximum(Calendar.DAY_OF_MONTH) < 36) {
            MAX_DAYS = 35;
        }

        List<Calendar> dates = new ArrayList<>();
        while (dates.size() < MAX_DAYS) {
            dates.add((Calendar) monthCalendar.clone());
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        // TODO: get schedules here
        List<Schedule> schedules = new ArrayList<>();

        calendarAdapter = new CalendarAdapter(getContext(), dates, selectedDate, schedules);
        gvDates.setAdapter(calendarAdapter);
    }

    @Override
    protected void setEvents() {
        ibPreviousMonth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showPrevMonth();
            }
        });
        ibNextMonth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextMonth();
            }
        });
        gvDates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectDateAndLoadCalendar(position);
            }
        });
    }

    // constructor

    public CustomCalendar(Context context) {
        super(context);
    }

    public CustomCalendar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomCalendar(Context context, AttributeSet attrs, int defStyleAttr, Context context1) {
        super(context, attrs, defStyleAttr);
    }
}
