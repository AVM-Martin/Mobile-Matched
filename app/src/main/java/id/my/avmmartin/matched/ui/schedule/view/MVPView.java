package id.my.avmmartin.matched.ui.schedule.view;

import java.util.Calendar;

import id.my.avmmartin.matched.ui.base.BaseMVPView;

public interface MVPView extends BaseMVPView {
    void addNewScheduleActivity();
    Calendar getSelectedDate();
}
