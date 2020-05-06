package id.my.avmmartin.matched.ui.schedule.edit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.components.add_menu.AddMenu;
import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BaseViewHolder;
import id.my.avmmartin.matched.utils.Constants;

public class EditScheduleActivity extends BaseActivity<Presenter> implements MVPView {

    private EditText etEventName;
    private EditText etEventLocation;
    private TextView tvEventStartDate;
    private TextView tvEventStartTime;
    private TextView tvEventEndDate;
    private TextView tvEventEndTime;
    private ImageButton ibCancelSchedule;
    private ImageButton ibAddSchedule;

    private Calendar startTime;
    private Calendar endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_schedule_edit);
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void initComponents() {
        etEventName = findViewById(R.id.etEventName);
        etEventLocation = findViewById(R.id.etEventLocation);

        tvEventStartDate = findViewById(R.id.tvEventStartDate);
        tvEventStartTime = findViewById(R.id.tvEventStartTime);

        tvEventEndDate = findViewById(R.id.tvEventEndDate);
        tvEventEndTime = findViewById(R.id.tvEventEndTime);

        ibAddSchedule = findViewById(R.id.ibAddSchedule);
        ibCancelSchedule = findViewById(R.id.ibCancelSchedule);

//        startTime = Calendar.getInstance();
//        startTime.setTimeInMillis(getIntent().getLongExtra(Constants.INTENT_SELECTED_DATE, 0));
//        startTime.add(Calendar.HOUR, 1);
//        startTime.set(Calendar.MINUTE, 0);
//        startTime.set(Calendar.SECOND, 0);
//
//        endTime = (Calendar) startTime.clone();
//        endTime.add(Calendar.HOUR, 1);

        AddMenu addMenu = findViewById(R.id.addMenu);
        addMenu.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void loadData() {
        //TODO: set according to data clicked
    }

    @Override
    protected void setEvents() {

    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }
}
