package id.my.avmmartin.matched.components.calendar;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.Inflater;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.data.db.model.Schedule;

public class CalendarAdapter extends ArrayAdapter {
    List<Date> dates;
    Calendar currentDate;
    List<Schedule> schedules;
    LayoutInflater inflater;

    public CalendarAdapter(@NonNull Context context, List<Date> dates, Calendar currentDate, List<Schedule> schedules) {
        super(context, R.layout.single_day_layout);

        this.dates = dates;
        this.currentDate = currentDate;
        this.schedules = schedules;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Date monthDate = dates.get(position);
        Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTime(monthDate);
        int day = dateCalendar.get(Calendar.DAY_OF_MONTH);
        int displayMonth = dateCalendar.get(Calendar.MONTH)+1;
        int displayYear = dateCalendar.get(Calendar.YEAR);
        int currentMonth = currentDate.get(Calendar.MONTH)+1;
        int currentYear = currentDate.get(Calendar.YEAR);

        View view = convertView;
        if(view == null) {
            view = inflater.inflate(R.layout.single_day_layout, parent, false);
        }

        TextView tvDay = view.findViewById(R.id.tvDay);
        tvDay.setText(String.valueOf(day));

        if(displayMonth == currentMonth && displayYear == currentYear){
            tvDay.setTextColor(Color.parseColor("#000000"));
        }
        else {
            tvDay.setTextColor(Color.parseColor("#CBCCCE"));
        }

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
}
