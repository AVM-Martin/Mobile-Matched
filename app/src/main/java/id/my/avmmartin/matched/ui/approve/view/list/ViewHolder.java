package id.my.avmmartin.matched.ui.approve.view.list;

import android.view.View;
import android.widget.TextView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.ui.base.BaseViewHolder;
import id.my.avmmartin.matched.utils.CommonUtils;

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
        // none
    }

    // constructor

    public ViewHolder(View itemView) {
        super(itemView);
    }
}
