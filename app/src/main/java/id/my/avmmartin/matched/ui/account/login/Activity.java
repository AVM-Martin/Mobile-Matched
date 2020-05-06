package id.my.avmmartin.matched.ui.account.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;

public class Activity extends BaseActivity<Presenter> implements MVPView {
    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnRegister;

    // mvp method

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_account_login);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.login_btn_login);
        btnRegister = findViewById(R.id.login_btn_register);
    }

    @Override
    protected void loadData() {
        // none
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
