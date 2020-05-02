package id.my.avmmartin.matched.ui.base;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseRecyclerViewAdapter<V extends BaseViewHolder> extends RecyclerView.Adapter<V> {
    @CallSuper
    @Override
    public void onBindViewHolder(@NonNull V holder, int position) {
        holder.loadData();
    }
}
