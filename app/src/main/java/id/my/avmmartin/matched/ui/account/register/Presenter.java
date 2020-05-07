package id.my.avmmartin.matched.ui.account.register;

import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BasePresenter;

public class Presenter extends BasePresenter<MVPView> implements MVPPresenter {
    @Override
    public void register() {
        // TODO: verify registration
        getMVPView().showMessage("TODO: registration");
    }

    // constructor

    Presenter(BaseActivity context) {
        super(context);
        onAttach((MVPView) context);
    }
}
