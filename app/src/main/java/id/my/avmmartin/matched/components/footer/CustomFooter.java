package id.my.avmmartin.matched.components.footer;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.components.base.BaseLinearLayout;
import id.my.avmmartin.matched.ui.account.AccountActivity;
import id.my.avmmartin.matched.ui.approve.view.ApprovalActivity;
import id.my.avmmartin.matched.ui.schedule.free.FreeScheduleActivity;
import id.my.avmmartin.matched.ui.schedule.view.Activity;

public class CustomFooter extends BaseLinearLayout implements MVPView {
    ImageView ivHome, ivApproval, ivFreeSchedule, ivAccount;

    public CustomFooter(Context context) {
        super(context);
    }

    public CustomFooter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void goToHome() {
        Intent intent = new Intent(getContext(), Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        getContext().startActivity(intent);
    }

    @Override
    public void goToApproval() {
        Intent intent = new Intent(getContext(), ApprovalActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        getContext().startActivity(intent);
    }

    @Override
    public void goToFreeSchedule() {
        Intent intent = new Intent(getContext(), FreeScheduleActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        getContext().startActivity(intent);
    }

    @Override
    public void goToAccount() {
        Intent intent = new Intent(getContext(), AccountActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        getContext().startActivity(intent);
    }

    @Override
    protected void initComponents() {
        Context context = getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.footer, this);

        ivHome = view.findViewById(R.id.ivHome);
        ivApproval = view.findViewById(R.id.ivApproval);
        ivFreeSchedule = view.findViewById(R.id.ivFreeSchedule);
        ivAccount = view.findViewById(R.id.ivAccount);

    }

    @Override
    protected void loadDatas() {

    }

    @Override
    protected void setEvents() {
        ivHome.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHome();
            }
        });
        ivApproval.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                goToApproval();
            }
        });
        ivFreeSchedule.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFreeSchedule();
            }
        });
        ivAccount.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAccount();
            }
        });
    }
}
