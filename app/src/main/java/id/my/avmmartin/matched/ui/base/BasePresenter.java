package id.my.avmmartin.matched.ui.base;

import android.content.Context;

import id.my.avmmartin.matched.data.AppDataManager;
import id.my.avmmartin.matched.data.DataManager;
import id.my.avmmartin.matched.data.ProtoManager;

public abstract class BasePresenter<V extends BaseMVPView> implements BaseMVPPresenter<V> {
    private final DataManager dataManager;
    private Context context;
    private V mvpView;

    public BasePresenter(BaseActivity context) {
//        this.dataManager = new AppDataManager(context);
        this.dataManager = new ProtoManager(context); // TODO: prototype
        this.context = context;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mvpView = null;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    protected Context getContext() {
        return context;
    }

    protected V getMVPView() {
        return mvpView;
    }
}
