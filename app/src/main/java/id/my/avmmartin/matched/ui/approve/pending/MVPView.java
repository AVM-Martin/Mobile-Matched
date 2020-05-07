package id.my.avmmartin.matched.ui.approve.pending;

import id.my.avmmartin.matched.ui.base.BaseMVPView;

public interface MVPView extends BaseMVPView {
    void onApproveRequest(String id);
    void onRejectRequest(String id);
}
