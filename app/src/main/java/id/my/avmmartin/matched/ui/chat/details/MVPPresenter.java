package id.my.avmmartin.matched.ui.chat.details;

import id.my.avmmartin.matched.ui.base.BaseMVPPresenter;

public interface MVPPresenter extends BaseMVPPresenter<MVPView> {
    void sendMessage(String message);
}
