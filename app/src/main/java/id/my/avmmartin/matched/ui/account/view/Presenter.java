package id.my.avmmartin.matched.ui.account.view;

import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.data.network.firestore.model.User;
import id.my.avmmartin.matched.exception.EmptyEntryException;
import id.my.avmmartin.matched.exception.GeneralException;
import id.my.avmmartin.matched.exception.InvalidTokenException;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BasePresenter;

public class Presenter extends BasePresenter<MVPView> implements MVPPresenter {
    Presenter(BaseActivity context) {
        super(context);
        onAttach((MVPView) context);
    }

    @Override
    public void loadUserData(EditText etUserName, EditText etFullName) {
        try {
            String username = getDataManager().getCurrentUsername();
            User user = getDataManager().getUser(username);

            etUserName.setText(username);
            etFullName.setText(user.getName());

        } catch (ExecutionException e) {
            //
        } catch (InterruptedException e) {
            //
        } catch (InvalidTokenException e) {
            getMVPView().showMessage(e.getMessage());
            getMVPView().logout();
        }
    }

    @Override
    public void updateAccount(EditText etUserName, EditText etFullName, EditText etPassword) throws GeneralException {
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

        // TODO: update profile
        throw new GeneralException("TODO: update profile", R.string.error_prototype);
    }

    @Override
    public void logout() {
        getDataManager().logout();
    }
}
