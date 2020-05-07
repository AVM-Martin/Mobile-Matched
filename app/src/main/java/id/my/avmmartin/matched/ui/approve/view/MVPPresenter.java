package id.my.avmmartin.matched.ui.approve.view;

import java.util.List;

import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.ui.base.BaseMVPPresenter;

public interface MVPPresenter extends BaseMVPPresenter<MVPView> {
    List<Schedule> getApprovedSchedule();
}
