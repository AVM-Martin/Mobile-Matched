package id.my.avmmartin.matched.ui.account.view;

import android.widget.EditText;

import id.my.avmmartin.matched.ui.base.BaseMVPPresenter;

public interface MVPPresenter extends BaseMVPPresenter<MVPView> {
    void loadUserData(EditText etUserName, EditText etFullName);

    void updateAccount();
    void logout();
}
