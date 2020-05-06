package id.my.avmmartin.matched.utils;

import android.os.AsyncTask;

import java.util.concurrent.Callable;

import id.my.avmmartin.matched.ui.base.BaseMVPView;

public class LoadDataUtils extends AsyncTask<Callable<Void>, Integer, Void> {
    private BaseMVPView baseMVPView;

    // overridden method

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        baseMVPView.showLoading();
    }

    @Override
    protected Void doInBackground(Callable<Void>... callables) {
        try {
            return callables[0].call();
        } catch (Exception e) {
            //
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void t) {
        super.onPostExecute(t);
        baseMVPView.hideLoading();
    }

    // constructor

    public LoadDataUtils(BaseMVPView baseMVPView) {
        super();
        this.baseMVPView = baseMVPView;
    }
}
