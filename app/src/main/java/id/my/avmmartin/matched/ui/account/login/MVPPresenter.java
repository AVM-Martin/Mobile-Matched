package id.my.avmmartin.matched.ui.account.login;

import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import id.my.avmmartin.matched.exception.GeneralException;
import id.my.avmmartin.matched.ui.base.BaseMVPPresenter;

public interface MVPPresenter extends BaseMVPPresenter<MVPView> {
    void login(EditText etUserName, EditText etPassword) throws InterruptedException, ExecutionException, GeneralException;
}
