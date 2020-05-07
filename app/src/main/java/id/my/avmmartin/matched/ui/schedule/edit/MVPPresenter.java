package id.my.avmmartin.matched.ui.schedule.edit;

import android.widget.TextView;

import java.util.Calendar;

import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.exception.DataIntegrityException;
import id.my.avmmartin.matched.ui.base.BaseMVPPresenter;

public interface MVPPresenter extends BaseMVPPresenter<MVPView> {
    Schedule getScheduleById(int id) throws DataIntegrityException;
    void showDatePickerDialog(final Calendar calendar, final TextView textView);
    void showTimePickerDialog(final Calendar calendar, final TextView textView);
}
