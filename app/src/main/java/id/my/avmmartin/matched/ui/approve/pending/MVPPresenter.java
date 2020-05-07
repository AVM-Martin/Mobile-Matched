package id.my.avmmartin.matched.ui.approve.pending;

import id.my.avmmartin.matched.ui.base.BaseMVPPresenter;

public interface MVPPresenter extends BaseMVPPresenter<MVPView> {
    void onApproveRequest();
    void onRejectRequest();
}
