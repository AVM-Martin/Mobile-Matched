package id.my.avmmartin.matched.ui.schedule.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import id.my.avmmartin.matched.data.db.model.Schedule;

public class CustomCalendar extends LinearLayout {
    ImageButton ibPreviousMonth, ibNextMonth;
    TextView tvCurrentMonth;
    GridView gvDates;
    Calendar calendar = Calendar.getInstance();
    Context context;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MMMM");

    List<Date> dates = new ArrayList<>();
    List<Schedule> schedules = new ArrayList<>();

    public CustomCalendar(Context context) {
        super(context);
    }

    public CustomCalendar(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
    }


}
