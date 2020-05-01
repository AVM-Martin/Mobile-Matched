package id.my.avmmartin.matched.components.calendar;

import id.my.avmmartin.matched.components.base.BaseMVPView;

interface MVPView extends BaseMVPView {
    void showPrevMonth();
    void showNextMonth();

    void selectDate(int position);
}
