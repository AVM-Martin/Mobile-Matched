package id.my.avmmartin.matched.ui.account;

import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BasePresenter;

public class Presenter extends BasePresenter<MVPView> implements MVPPresenter {
    Presenter(BaseActivity context) {
        super(context);
        onAttach((MVPView) context);
    }
}
