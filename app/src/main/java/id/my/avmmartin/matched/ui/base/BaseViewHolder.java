package id.my.avmmartin.matched.ui.base;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<Model extends Object> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);

        initComponents();
        setEvents();
    }

    protected abstract void initComponents();
    protected abstract void loadData();
    protected abstract void setEvents();

    private Model data;

    public void bindData(Model data) {
        this.data = data;
    }

    public Model getData() {
        return data;
    }
}
