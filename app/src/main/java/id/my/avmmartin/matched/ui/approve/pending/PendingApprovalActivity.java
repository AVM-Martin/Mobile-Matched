package id.my.avmmartin.matched.ui.approve.pending;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.approve.pending.list.ApprovalAdapter;
import id.my.avmmartin.matched.ui.base.BaseActivity;

public class PendingApprovalActivity extends BaseActivity<Presenter> implements MVPView {
    private RecyclerView rvListApproval;
    private ApprovalAdapter approvalAdapter;

    // mvp method

    @Override
    public void onApproveRequest(String id) {
        presenter.onApproveRequest(id);
        approvalAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRejectRequest(String id) {
        presenter.onRejectRequest(id);
        approvalAdapter.notifyDataSetChanged();
    }

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_approval_pending);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {
        rvListApproval = findViewById(R.id.rvListApproval);

        ImageView ivApproval = findViewById(R.id.ivApproval);
        ivApproval.setImageResource(R.drawable.notifications_selected_24dp);
        ivApproval.setClickable(false);
    }

    @Override
    protected void loadData() {
        approvalAdapter = new ApprovalAdapter(this, presenter.getDataManager());
        rvListApproval.setLayoutManager(new LinearLayoutManager(this));
        rvListApproval.setAdapter(approvalAdapter);
    }

    @Override
    protected void loadOnlineData() {
        approvalAdapter.loadUsername();
    }

    @Override
    protected void postLoadOnlineData() {
        super.postLoadOnlineData();
        approvalAdapter.notifyDataSetChanged();
    }

    @Override
    protected void setEvents() {
        approvalAdapter.setListener(new ApprovalAdapter.Listener() {
            @Override
            public void onCancelScheduleApprovalClick(String id) {
                onRejectRequest(id);
            }

            @Override
            public void onAddScheduleApprovalClick(String id) {
                onApproveRequest(id);
            }
        });
    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }
}
