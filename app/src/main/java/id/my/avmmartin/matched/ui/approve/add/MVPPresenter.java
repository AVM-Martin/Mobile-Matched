package id.my.avmmartin.matched.ui.approve.add;

import android.widget.TextView;

import java.util.Calendar;

import id.my.avmmartin.matched.ui.base.BaseMVPPresenter;

public interface MVPPresenter extends BaseMVPPresenter<MVPView> {
    void showDatePickerDialog(final Calendar calendar, final TextView textView);
}
