package id.my.avmmartin.matched.utils;

import android.os.AsyncTask;

import java.util.concurrent.Callable;

import id.my.avmmartin.matched.ui.base.BaseMVPView;

public class LoadDataUtils<T extends Object> extends AsyncTask<Callable<T>, Integer, T> {
    private BaseMVPView baseMVPView;

    // overridden method

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        baseMVPView.showLoading();
    }

    @Override
    protected T doInBackground(Callable<T>... callables) {
        try {
            return callables[0].call();
        } catch (Exception e) {
            //
        }

        return null;
    }

    @Override
    protected void onPostExecute(T t) {
        super.onPostExecute(t);
        baseMVPView.hideLoading();
    }

    // constructor

    public LoadDataUtils(BaseMVPView baseMVPView) {
        super();
        this.baseMVPView = baseMVPView;
    }
}
