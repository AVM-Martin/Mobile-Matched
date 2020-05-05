package id.my.avmmartin.matched.ui.approve.add;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BasePresenter;
import id.my.avmmartin.matched.utils.CommonUtils;

public class Presenter extends BasePresenter<MVPView> implements MVPPresenter {
    public void showDatePickerDialog(final Calendar calendar, final TextView textView) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
            getContext(),
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, month);
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    textView.setText(CommonUtils.toDateFormat(calendar));
                }
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.show();
    }

    Presenter(BaseActivity context) {
        super(context);
        onAttach((MVPView) context);
    }
}
