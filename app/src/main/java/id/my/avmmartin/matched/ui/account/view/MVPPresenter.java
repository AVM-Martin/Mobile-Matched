package id.my.avmmartin.matched.ui.account.view;

import id.my.avmmartin.matched.ui.base.BaseMVPPresenter;

public interface MVPPresenter extends BaseMVPPresenter<MVPView> {
    void updateAccount();
    void logout();
}
