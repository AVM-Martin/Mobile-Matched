package id.my.avmmartin.matched.ui.account.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.account.register.RegisterActivity;
import id.my.avmmartin.matched.ui.base.BaseActivity;

public class LoginActivity extends BaseActivity<Presenter> implements MVPView {
    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnRegister;

    // mvp method

    @Override
    public void btnLoginOnClick() {
        presenter.login();
    }

    @Override
    public void btnRegisterOnClick() {
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

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
