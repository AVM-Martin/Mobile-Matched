package id.my.avmmartin.matched.ui.schedule.view.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.Calendar;
import java.util.List;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.data.DataManager;
import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.exception.DataIntegrityException;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BaseRecyclerViewAdapter;
import id.my.avmmartin.matched.ui.schedule.view.MVPView;

public class Adapter extends BaseRecyclerViewAdapter<ViewHolder> {
    // overridden method

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.single_schedule_view, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            Calendar selectedDate = ((MVPView) activity).getSelectedDate();

            // TODO: get schedule with order and limit
            List<Schedule> schedules = dataManager.getScheduleByDate(
                selectedDate.get(Calendar.YEAR),
                selectedDate.get(Calendar.MONTH),
                selectedDate.get(Calendar.DATE)
            );

            holder.bindData(schedules.get(position));
            super.onBindViewHolder(holder, position);

        } catch (DataIntegrityException e) {
            activity.showMessage(e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        Calendar selectedDate = ((MVPView) activity).getSelectedDate();

        return dataManager.sizeByDate(
            selectedDate.get(Calendar.YEAR),
            selectedDate.get(Calendar.MONTH),
            selectedDate.get(Calendar.DATE)
        );
    }

    // constructor

    private BaseActivity activity;
    private DataManager dataManager;

    public Adapter(BaseActivity activity) {
        this.activity = activity;
        this.dataManager = new DataManager(activity);
    }
}
