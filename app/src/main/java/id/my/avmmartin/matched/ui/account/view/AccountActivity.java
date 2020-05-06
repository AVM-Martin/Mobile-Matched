package id.my.avmmartin.matched.ui.account.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;

public class AccountActivity extends BaseActivity<Presenter> implements MVPView {
    private EditText etUserName;
    private EditText etFullName;
    private EditText etPassword;
    private Button btnUpdate;
    private Button btnLogout;

    // mvp method

    @Override
    public void updateAccount() {
        presenter.updateAccount();
        loadData();
        showMessage("User account updated");
    }

    @Override
    public void logout() {
        presenter.logout();
        // TODO: logout current user
    }

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_account_view);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {
        etUserName = findViewById(R.id.etUserName);
        etFullName = findViewById(R.id.etFullName);
        etPassword = findViewById(R.id.etPassword);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnLogout = findViewById(R.id.btnLogout);

        ImageView ivAccount = findViewById(R.id.ivAccount);
        ivAccount.setImageResource(R.drawable.account_selected_24dp);
        ivAccount.setClickable(false);
    }

    @Override
    protected void loadData() {
        etPassword.setText("");
    }

    @Override
    protected void setEvents() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAccount();
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }

    @Override
    protected void loadOnlineData() {
        presenter.loadUserData(etUserName, etFullName);
    }
}
