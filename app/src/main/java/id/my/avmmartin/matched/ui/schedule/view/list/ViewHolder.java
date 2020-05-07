package id.my.avmmartin.matched.ui.schedule.view.list;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.ui.base.BaseViewHolder;
import id.my.avmmartin.matched.ui.schedule.edit.EditScheduleActivity;
import id.my.avmmartin.matched.utils.CommonUtils;
import id.my.avmmartin.matched.utils.Constants;

public class ViewHolder extends BaseViewHolder<Schedule> {
    private TextView tvScheduleTitle;
    private TextView tvScheduleTimeAndPlace;

    @Override
    protected void initComponents() {
        tvScheduleTitle = itemView.findViewById(R.id.tvScheduleTitle);
        tvScheduleTimeAndPlace = itemView.findViewById(R.id.tvScheduleTimeAndPlace);
    }

    @Override
    protected void loadData() {
        tvScheduleTitle.setText(getData().getName());
        tvScheduleTimeAndPlace.setText(
            CommonUtils.toTimeFormat(getData().getStartTime())
                + " "
                + getData().getLocation()
        );
    }

    @Override
    protected void setEvents() {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), EditScheduleActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intent.putExtra(Constants.INTENT_SELECTED_SCHEDULE_ID, getData().getId());
                itemView.getContext().startActivity(intent);
            }
        });
    }

    // constructor

    public ViewHolder(View itemView) {
        super(itemView);
    }
}
