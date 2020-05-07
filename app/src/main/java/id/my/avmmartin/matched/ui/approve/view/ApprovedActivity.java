package id.my.avmmartin.matched.ui.approve.view;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;
import id.my.avmmartin.matched.ui.approve.view.list.Adapter;

public class ApprovedActivity extends BaseActivity<Presenter> implements MVPView {
    private RecyclerView rvListApproval;

    private Adapter adapter;

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_approval_view);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {
        rvListApproval = findViewById(R.id.rvListApproval);

        ImageView ivFreeSchedule = findViewById(R.id.ivFreeSchedule);
        ivFreeSchedule.setImageResource(R.drawable.list_selected_24dp);
        ivFreeSchedule.setClickable(false);
    }

    @Override
    protected void loadData() {
        // none
    }

    @Override
    protected void loadOnlineData() {
        adapter = new Adapter(this, presenter.getApprovedSchedule());
        rvListApproval.setLayoutManager(new LinearLayoutManager(this));
        rvListApproval.setAdapter(adapter);
    }

    @Override
    protected void setEvents() {
        // none
    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }
}
