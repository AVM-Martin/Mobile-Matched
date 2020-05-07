package id.my.avmmartin.matched.ui.approve.pending;

import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BasePresenter;

public class Presenter extends BasePresenter<MVPView> implements MVPPresenter{
    Presenter(BaseActivity context) {
        super(context);
        onAttach((MVPView) context);
    }

    @Override
    public void onApproveRequest(String id) {
        // TODO: compare then send to menu 3
        getMVPView().showMessage("TODO: approve me");
    }

    @Override
    public void onRejectRequest(String id) {
        // TODO: delete approval
        getMVPView().showMessage("TODO: reject me");
    }
}
