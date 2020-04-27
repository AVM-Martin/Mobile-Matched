package id.my.avmmartin.matched.ui.base;

import id.my.avmmartin.matched.data.DataManager;

public abstract class BasePresenter<V extends BaseMVPView> implements BaseMVPPresenter<V> {
    private final DataManager dataManager;
    protected V mvpView;

    public BasePresenter(BaseActivity context) {
        this.dataManager = new DataManager(context);
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
}
