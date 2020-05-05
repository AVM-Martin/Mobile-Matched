package id.my.avmmartin.matched.ui.approve.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.approve.view.list.ApprovalAdapter;
import id.my.avmmartin.matched.ui.base.BaseActivity;

public class ApprovalActivity extends BaseActivity<Presenter> implements MVPView {
    private RecyclerView rvListApproval;
    private ApprovalAdapter approvalAdapter;

    // mvp method

    @Override
    public void onApproveRequest() {
        presenter.onApproveRequest();
        approvalAdapter.notifyDataSetChanged();
        // TODO: compare then send to menu 3
    }

    @Override
    public void onRejectRequest() {
        presenter.onRejectRequest();
        approvalAdapter.notifyDataSetChanged();
    }

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_approval_view);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {
        rvListApproval = findViewById(R.id.rvListApproval);

        ImageView ivApproval = findViewById(R.id.ivApproval);
        ivApproval.setImageResource(R.drawable.notifications_selected_24dp);
    }

    @Override
    protected void loadData() {
        approvalAdapter = new ApprovalAdapter(ApprovalActivity.this);
        rvListApproval.setLayoutManager(new LinearLayoutManager(this));
        rvListApproval.setAdapter(approvalAdapter);
    }

    @Override
    protected void setEvents() {
        approvalAdapter.setListener(new ApprovalAdapter.Listener() {
            @Override
            public void onCancelScheduleApprovalClick() {
                onRejectRequest();
            }

            @Override
            public void onAddScheduleApprovalClick() {
                onApproveRequest();
            }
        });
    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }
}
