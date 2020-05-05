package id.my.avmmartin.matched.ui.approve.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BasePresenter;
import id.my.avmmartin.matched.utils.CommonUtils;

public class Presenter extends BasePresenter<MVPView> implements MVPPresenter{
    Presenter(BaseActivity context) {
        super(context);
        onAttach((MVPView) context);
    }

    @Override
    public void onApproveRequest() {
        // TODO: compare then send to menu 3
    }

    @Override
    public void onRejectRequest() {
        // TODO: delete approval
    }

    public static List<Schedule> compareSchedule(List<Schedule> schedules1, List<Schedule> schedules2) {
        List<Schedule> listFreeSchedules = new ArrayList<>();
        boolean flag[] = new boolean[1445];
        for(int i=0; i<1440; i++) flag[i] = false;
        flag[1440] = true;
        for(int i=0; i<schedules1.size(); i++) {
            Schedule schedule = schedules1.get(i);
            int st = CommonUtils.toMinuteFormat(schedule.getStartTime());
            int en = CommonUtils.toMinuteFormat(schedule.getEndTime());
            for(int j=st; j<=en; j++) flag[j] = true;
        }
        for(int i=0; i<schedules2.size(); i++) {
            Schedule schedule = schedules2.get(i);
            int st = CommonUtils.toMinuteFormat(schedule.getStartTime());
            int en = CommonUtils.toMinuteFormat(schedule.getEndTime());
            for(int j=st; j<=en; j++) flag[j] = true;
        }
        int st = 0, en;
        for(int i=0; i<=1440; i++) {
            if(flag[i]) {
                en = i-1;
                if(en-st > 0) {
                    Calendar startTime = Calendar.getInstance();
                    startTime.set(Calendar.HOUR, st / 60);
                    startTime.set(Calendar.MINUTE, st % 60);

                    Calendar endTime = Calendar.getInstance();
                    endTime.set(Calendar.HOUR, en / 60);
                    endTime.set(Calendar.MINUTE, en % 60);
                    try {
                        listFreeSchedules.add(new Schedule("Free schedule" + listFreeSchedules.size() + 1, "", startTime, endTime));
                    } catch (Exception e) {

                    }
                }
                st = i+1;
            }
        }
        return listFreeSchedules;
    }
}
