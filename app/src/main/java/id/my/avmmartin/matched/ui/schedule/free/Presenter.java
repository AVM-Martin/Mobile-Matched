package id.my.avmmartin.matched.ui.schedule.free;

import java.util.List;
import java.util.Vector;

import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BasePresenter;

public class Presenter extends BasePresenter<MVPView> implements MVPPresenter {
    @Override
    public List<Schedule> getFreeScheduleList() {
        List<Schedule> schedules = new Vector<>();

        // TODO: list

        return schedules;
    }

    Presenter(BaseActivity context) {
        super(context);
        onAttach((MVPView) context);
    }
}
