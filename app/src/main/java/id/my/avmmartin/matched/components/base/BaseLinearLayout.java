package id.my.avmmartin.matched.components.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public abstract class BaseLinearLayout extends LinearLayout implements BaseMVPView {

    protected abstract void initComponents();
    protected abstract void loadDatas();
    protected abstract void setEvents();

    // constructor

    public BaseLinearLayout(Context context) {
        super(context);

        initComponents();
        loadDatas();
        setEvents();
    }

    public BaseLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        initComponents();
        loadDatas();
        setEvents();
    }

    public BaseLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initComponents();
        loadDatas();
        setEvents();
    }

    public BaseLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        initComponents();
        loadDatas();
        setEvents();
    }
}
