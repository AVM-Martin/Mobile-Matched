package id.my.avmmartin.matched.ui.account.register;

import android.widget.EditText;

import id.my.avmmartin.matched.exception.EmptyEntryException;
import id.my.avmmartin.matched.exception.GeneralException;
import id.my.avmmartin.matched.ui.base.BaseMVPPresenter;

public interface MVPPresenter extends BaseMVPPresenter<MVPView> {
    void register(EditText etUserName, EditText etFullName, EditText etPassword) throws GeneralException;
}
