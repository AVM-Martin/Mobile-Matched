package id.my.avmmartin.matched.ui.schedule.view;

import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BasePresenter;

class Presenter extends BasePresenter<MVPView> implements MVPPresenter {
    Presenter(BaseActivity context) {
        super(context);
        onAttach((MVPView) context);
    }
}
