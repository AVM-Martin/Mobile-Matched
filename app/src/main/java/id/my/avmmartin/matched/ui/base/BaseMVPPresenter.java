package id.my.avmmartin.matched.ui.base;

public interface BaseMVPPresenter<V extends BaseMVPView> {
    void onAttach(V mvpView);
    void onDetach();
}
