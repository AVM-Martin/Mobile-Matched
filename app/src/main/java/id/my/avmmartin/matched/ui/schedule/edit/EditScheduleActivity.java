package id.my.avmmartin.matched.ui.schedule.edit;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.components.add_menu.AddMenu;
import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.exception.DataIntegrityException;
import id.my.avmmartin.matched.exception.InvalidDurationException;
import id.my.avmmartin.matched.exception.NoTitleException;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.utils.CommonUtils;
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

    private Schedule schedule;

    // mvp method

    @Override
    public void updateSchedule() {
        try {
            schedule.setName(etEventName.getText().toString());
            schedule.setLocation(etEventLocation.getText().toString());

            presenter.getDataManager().updateSchedule(schedule);

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

        try {
            schedule = presenter.getScheduleById(
                getIntent().getIntExtra(Constants.INTENT_SELECTED_SCHEDULE_ID, 0)
            );

        } catch (DataIntegrityException e) {
            showMessage(e.getMessage());
            finish();
        }

        AddMenu addMenu = findViewById(R.id.addMenu);
        addMenu.setVisibility(View.GONE);
    }

    @Override
    protected void loadData() {
        etEventName.setText(schedule.getName());
        etEventLocation.setText(schedule.getLocation());

        tvEventStartDate.setText(CommonUtils.toDateFormat(schedule.getStartTime()));
        tvEventStartTime.setText(CommonUtils.toTimeFormat(schedule.getStartTime()));

        tvEventEndDate.setText(CommonUtils.toDateFormat(schedule.getEndTime()));
        tvEventEndTime.setText(CommonUtils.toTimeFormat(schedule.getEndTime()));
    }

    @Override
    protected void setEvents() {
        tvEventStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showDatePickerDialog(schedule.getStartTime(), tvEventStartDate);
            }
        });
        tvEventStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showTimePickerDialog(schedule.getStartTime(), tvEventStartTime);
            }
        });
        tvEventEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showDatePickerDialog(schedule.getEndTime(), tvEventEndDate);
            }
        });
        tvEventEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showTimePickerDialog(schedule.getEndTime(), tvEventEndTime);
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
                updateSchedule();
            }
        });
    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }
}
