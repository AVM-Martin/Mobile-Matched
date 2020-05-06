package id.my.avmmartin.matched.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Callable;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.utils.CommonUtils;
import id.my.avmmartin.matched.utils.LoadDataUtils;

public abstract class BaseActivity<V extends BasePresenter> extends AppCompatActivity implements BaseMVPView {
    private ProgressDialog progressDialog;
    protected V presenter;

    @CallSuper
    @Override
    protected void onStart() {
        super.onStart();

        initPresenter();
        initComponents();
        loadData();
        setEvents();
    }

    @CallSuper
    @Override
    protected void onResume() {
        super.onResume();

        new LoadDataUtils(this).execute(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                loadOnlineData();
                return null;
            }
        });
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }

    protected abstract void initPresenter();
    protected abstract void initComponents();
    protected abstract void loadData();
    protected abstract void setEvents();
    protected void loadOnlineData() {
        // none
    }

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
