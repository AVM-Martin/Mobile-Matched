package id.my.avmmartin.matched.ui.base;

import androidx.annotation.StringRes;

public interface BaseMVPView {
    void showLoading();
    void hideLoading();

    void onError(@StringRes int resId);
    void onError(String message);

    void showMessage(String message);
    void showMessage(@StringRes int resId);
}
