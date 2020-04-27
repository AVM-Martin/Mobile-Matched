package id.my.avmmartin.matched.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.utils.CommonUtils;

public abstract class BaseActivity<V extends BasePresenter> extends AppCompatActivity implements BaseMVPView {
    private ProgressDialog progressDialog;
    protected V presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initComponents();
        loadData();
        setEvents();
        initPresenter();
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }

    protected abstract void initComponents();
    protected abstract void loadData();
    protected abstract void setEvents();
    protected abstract void initPresenter();

    @Override
    public void showLoading() {
        hideLoading();
        progressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
    }

    private void showSnackBar(String message) {
        // TODO: to be implemented
    }

    @Override
    public void onError(String message) {
        if (message != null) {
            showSnackBar(message);
        } else {
            showSnackBar(getString(R.string.some_error));
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        onError(getString(resId));
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        showMessage(getString(resId));
    }
}
