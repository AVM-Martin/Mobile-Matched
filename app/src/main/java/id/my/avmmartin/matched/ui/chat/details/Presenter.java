package id.my.avmmartin.matched.ui.chat.details;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.base.BasePresenter;

public class Presenter extends BasePresenter<MVPView> implements MVPPresenter {
    Presenter(BaseActivity context) {
        super(context);
        onAttach((MVPView) context);
    }

    @Override
    public void sendMessage(String message) {
        // TODO: send message to chat
        getMVPView().showMessage(R.string.error_prototype);
    }
}
