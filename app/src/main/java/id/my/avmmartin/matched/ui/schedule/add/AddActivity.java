package id.my.avmmartin.matched.ui.schedule.add;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.exception.InvalidDurationException;
import id.my.avmmartin.matched.exception.NoTitleException;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.utils.CommonUtils;
import id.my.avmmartin.matched.utils.Constants;

public class AddActivity extends BaseActivity<Presenter> implements MVPView {
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

    // mvp method

    @Override
    public void addSchedule() {
        try {
            Schedule schedule = new Schedule(
                etEventName.getText().toString(),
                etEventLocation.getText().toString(),
                startTime,
                endTime
            );
            presenter.getDataManager().insertSchedule(schedule);

            finish();

        } catch (NoTitleException e) {
            showMessage(e.getMessage());
        } catch (InvalidDurationException e) {
            showMessage(e.getMessage());
        }
    }

    @Override
    public void cancelSchedule() {
        finish();
    }

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_schedule_add);
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

        startTime = Calendar.getInstance();
        startTime.setTimeInMillis(getIntent().getLongExtra(Constants.INTENT_SELECTED_DATE, 0));
        startTime.add(Calendar.HOUR, 1);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.SECOND, 0);

        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 1);

        ImageView ivAddSchedule = findViewById(R.id.ivAddSchedule);
        ivAddSchedule.setImageResource(R.drawable.schedule_selected_24dp);
        ivAddSchedule.setClickable(false);
    }

    @Override
    protected void loadData() {
        tvEventStartDate.setText(CommonUtils.toDateFormat(startTime));
        tvEventStartTime.setText(CommonUtils.toTimeFormat(startTime));

        tvEventEndDate.setText(CommonUtils.toDateFormat(endTime));
        tvEventEndTime.setText(CommonUtils.toTimeFormat(endTime));
    }

    @Override
    protected void setEvents() {
        tvEventStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showDatePickerDialog(startTime, tvEventStartDate);
            }
        });
        tvEventStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showTimePickerDialog(startTime, tvEventStartTime);
            }
        });
        tvEventEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showDatePickerDialog(endTime, tvEventEndDate);
            }
        });
        tvEventEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showTimePickerDialog(endTime, tvEventEndTime);
            }
        });

        ibCancelSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelSchedule();
            }
        });
        ibAddSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSchedule();
            }
        });

    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }
}
