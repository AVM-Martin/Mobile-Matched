package id.my.avmmartin.matched.ui.approve.add;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.utils.CommonUtils;

public class AddApproval extends BaseActivity<Presenter> implements MVPView{
    private EditText etUsername;
    private TextView tvApprovalDate;
    private ImageButton ibCancelApproval;
    private ImageButton ibAddApproval;

    private Calendar approvalDate;

    // mvp method

    @Override
    public void addApproval() {
        // TODO: add approval
    }

    @Override
    public void cancelApproval() {
        finish();
    }

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_approval_add);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {
        etUsername = findViewById(R.id.etUserName);
        tvApprovalDate = findViewById(R.id.tvApprovalDate);
        ibAddApproval = findViewById(R.id.ibAddApproval);
        ibCancelApproval = findViewById(R.id.ibCancelApproval);

        approvalDate = Calendar.getInstance();

        ImageView ivCompareSchedule = findViewById(R.id.ivCompareSchedule);
        ivCompareSchedule.setImageResource(R.drawable.compare_selected_24dp);
        ivCompareSchedule.setClickable(false);
    }

    @Override
    protected void loadData() {
        tvApprovalDate.setText(CommonUtils.toDateFormat(approvalDate));
    }

    @Override
    protected void setEvents() {
        tvApprovalDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showDatePickerDialog(approvalDate, tvApprovalDate);
            }
        });

        ibCancelApproval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelApproval();
            }
        });
        ibAddApproval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addApproval();
            }
        });
    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }

}
