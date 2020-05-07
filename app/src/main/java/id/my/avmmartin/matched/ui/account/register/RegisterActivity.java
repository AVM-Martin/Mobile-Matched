package id.my.avmmartin.matched.ui.account.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.account.login.LoginActivity;
import id.my.avmmartin.matched.ui.base.BaseActivity;

public class RegisterActivity extends BaseActivity<Presenter> implements MVPView {
    private EditText etUserName;
    private EditText etFullName;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnRegister;

    // mvp method

    @Override
    public void btnLoginOnClick() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void btnRegisterOnClick() {
        presenter.register();
        btnLoginOnClick();
    }

    // overridden method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_account_register);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {
        etUserName = findViewById(R.id.etUserName);
        etFullName = findViewById(R.id.etFullName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.register_btn_login);
        btnRegister = findViewById(R.id.register_btn_register);
    }

    @Override
    protected void loadData() {
        // none
    }

    @Override
    protected void setEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLoginOnClick();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegisterOnClick();
            }
        });
    }

    @Override
    protected void initPresenter() {
        presenter = new Presenter(this);
    }
}
