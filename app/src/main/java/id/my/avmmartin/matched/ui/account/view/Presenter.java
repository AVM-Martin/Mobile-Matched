package id.my.avmmartin.matched.ui.account.view;

import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import id.my.avmmartin.matched.data.network.firestore.model.User;
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
    public void updateAccount() {
        // TODO: update profile
        getMVPView().showMessage("TODO: update profile");
    }

    @Override
    public void logout() {
        // TODO: logout
        getMVPView().showMessage("TODO: logout");
    }
}
