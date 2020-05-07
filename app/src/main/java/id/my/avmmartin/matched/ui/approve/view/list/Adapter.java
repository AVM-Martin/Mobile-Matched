package id.my.avmmartin.matched.ui.approve.view.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BaseRecyclerViewAdapter;

public class Adapter extends BaseRecyclerViewAdapter<ViewHolder> {
    // overridden method

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.list_schedule_view, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(schedules.get(position));
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }

    // constructor

    private BaseActivity activity;
    private List<Schedule> schedules;

    public Adapter(BaseActivity activity, List<Schedule> schedules) {
        this.activity = activity;
        this.schedules = schedules;
    }
}
