package id.my.avmmartin.matched.ui.account.login;

import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BasePresenter;

public class Presenter extends BasePresenter<MVPView> implements MVPPresenter {
    @Override
    public void login() {
        // TODO: verify login
        getMVPView().showMessage("TODO: login");
    }

    // constructor

    Presenter(BaseActivity context) {
        super(context);
        onAttach((MVPView) context);
    }
}
