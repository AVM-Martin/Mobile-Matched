package id.my.avmmartin.matched.components.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Calendar;
import java.util.List;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.data.AppDataManager;
import id.my.avmmartin.matched.data.DataManager;
import id.my.avmmartin.matched.ui.base.BaseActivity;

class CalendarAdapter extends ArrayAdapter {
    private List<Calendar> dates;
    private Calendar currentDate;
    private LayoutInflater inflater;
    private DataManager dataManager;

    // overridden method

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int currentMonth = currentDate.get(Calendar.MONTH);
        int currentYear = currentDate.get(Calendar.YEAR);

        Calendar dateCalendar = dates.get(position);

        int day = dateCalendar.get(Calendar.DAY_OF_MONTH);
        int displayMonth = dateCalendar.get(Calendar.MONTH);
        int displayYear = dateCalendar.get(Calendar.YEAR);

        View view = convertView;
        if(view == null) {
            view = inflater.inflate(R.layout.single_day_layout, parent, false);
        }

        if (currentDate.equals(dateCalendar)) {
            view.setBackgroundColor(R.style.CustomCalendar_Today);
        }

        // date number

        TextView tvDay = view.findViewById(R.id.tvDay);
        tvDay.setText(String.valueOf(day));

        if (displayMonth == currentMonth && displayYear == currentYear) {
            tvDay.setTextAppearance(R.style.CustomCalendar_ThisMonth);
        } else {
            tvDay.setTextAppearance(R.style.CustomCalendar_OtherMonth);
        }

        // get schedule
        // TODO: show the schedule with dot

        int numberOfSchedules = dataManager.sizeByDate(displayYear, displayMonth, day);

        TextView tvSchedule = view.findViewById(R.id.tvSchedule);
        tvSchedule.setText(String.valueOf(numberOfSchedules));

        return view;
    }

    @Override
    public int getCount() {
        return dates.size();
    }

    @Override
    public int getPosition(@Nullable Object item) {
        return dates.indexOf(item);
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return dates.get(position);
    }

    // constructor

    CalendarAdapter(@NonNull Context context, List<Calendar> dates, Calendar currentDate) {
        super(context, R.layout.single_day_layout);

        this.dates = dates;
        this.currentDate = currentDate;
        this.inflater = LayoutInflater.from(context);
        this.dataManager = new AppDataManager(context);
    }
}
