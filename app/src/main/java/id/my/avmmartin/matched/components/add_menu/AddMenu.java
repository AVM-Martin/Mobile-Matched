package id.my.avmmartin.matched.components.add_menu;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.components.base.BaseLinearLayout;
import id.my.avmmartin.matched.ui.approve.add.AddApproval;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.schedule.add.AddActivity;
import id.my.avmmartin.matched.ui.schedule.view.Activity;
import id.my.avmmartin.matched.utils.Constants;

public class AddMenu extends BaseLinearLayout implements MVPView {

    ImageView ivAddSchedule, ivCompareSchedule;

    public AddMenu(Context context) {
        super(context);
    }

    public AddMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void goToAddSchedule() {
        Intent intent = new Intent(getContext(), AddActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        getContext().startActivity(intent);
        ((android.app.Activity)getContext()).finish();
    }

    @Override
    public void goToAddApproval() {
        Intent intent = new Intent(getContext(), AddApproval.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        getContext().startActivity(intent);
        ((android.app.Activity)getContext()).finish();
    }

    @Override
    protected void initComponents() {
        Context context = getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.add_menu, this);

        ivAddSchedule = view.findViewById(R.id.ivAddSchedule);
        ivCompareSchedule = view.findViewById(R.id.ivCompareSchedule);
    }

    @Override
    protected void loadDatas() {

    }

    @Override
    protected void setEvents() {
        ivAddSchedule.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAddSchedule();
            }
        });

        ivCompareSchedule.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAddApproval();
            }
        });
    }


}
