package id.my.avmmartin.matched.ui.account.login;

import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.exception.EmptyEntryException;
import id.my.avmmartin.matched.exception.GeneralException;
import id.my.avmmartin.matched.exception.InvalidCredentialsException;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BasePresenter;

public class Presenter extends BasePresenter<MVPView> implements MVPPresenter {
    @Override
    public void login(EditText etUserName, EditText etPassword) throws InterruptedException, ExecutionException, GeneralException {
        String username = etUserName.getText().toString();
        String password = etPassword.getText().toString();

        if (username.equals("")) {
            throw new EmptyEntryException(R.string.warning_empty_username);
        }

        if (password.equals("")) {
            throw new EmptyEntryException(R.string.warning_empty_password);
        }

        getDataManager().login(username, password);
    }

    // constructor

    Presenter(BaseActivity context) {
        super(context);
        onAttach((MVPView) context);
    }
}
