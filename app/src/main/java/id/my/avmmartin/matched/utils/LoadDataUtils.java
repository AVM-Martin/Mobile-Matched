package id.my.avmmartin.matched.utils;

import android.os.AsyncTask;

import java.util.concurrent.Callable;

public class LoadDataUtils extends AsyncTask<Callable<Void>, Integer, Void> {
    public interface Listener {
        void onPreExecute();
        void onPostExecute();
    }

    private Listener listener;

    // overridden method

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listener.onPreExecute();
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
        listener.onPostExecute();
    }

    // constructor

    public LoadDataUtils(Listener listener) {
        super();
        this.listener = listener;
    }
}
