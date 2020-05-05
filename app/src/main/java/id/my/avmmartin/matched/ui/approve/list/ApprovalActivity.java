package id.my.avmmartin.matched.ui.approve.list;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;

public class ApprovalActivity extends BaseActivity<Presenter> implements MVPView {

    RecyclerView rvListApproval;
    ApprovalAdapter approvalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_approval_list);
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ApprovalActivity.this);
        rvListApproval.setLayoutManager(linearLayoutManager);
        rvListApproval.setAdapter(approvalAdapter);
    }

    @Override
    protected void setEvents() {

    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }
}
