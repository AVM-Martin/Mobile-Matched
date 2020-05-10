package id.my.avmmartin.matched.ui.account.register;

import android.widget.EditText;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.exception.EmptyEntryException;
import id.my.avmmartin.matched.exception.GeneralException;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BasePresenter;

public class Presenter extends BasePresenter<MVPView> implements MVPPresenter {
    @Override
    public void register(EditText etUserName, EditText etFullName, EditText etPassword) throws GeneralException {
        String username = etUserName.getText().toString();
        String fullName = etFullName.getText().toString();
        String password = etPassword.getText().toString();

        if (username.equals("")) {
            throw new EmptyEntryException(R.string.warning_empty_username);
        }

        if (fullName.equals("")) {
            throw new EmptyEntryException(R.string.warning_empty_fullname);
        }

        if (password.equals("")) {
            throw new EmptyEntryException(R.string.warning_empty_password);
        }

        // TODO: verify registration
        throw new GeneralException("TODO: verify registration", R.string.error_prototype);
    }

    // constructor

    Presenter(BaseActivity context) {
        super(context);
        onAttach((MVPView) context);
    }
}
