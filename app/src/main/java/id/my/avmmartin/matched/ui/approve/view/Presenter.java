package id.my.avmmartin.matched.ui.approve.view;

import java.util.List;
import java.util.Vector;

import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BasePresenter;

public class Presenter extends BasePresenter<MVPView> implements MVPPresenter {
    Presenter(BaseActivity context) {
        super(context);
        onAttach((MVPView) context);
    }

    @Override
    public List<Schedule> getApprovedSchedule() {
        List<Schedule> schedules = new Vector<>();

        // TODO: list

        return schedules;
    }
}
