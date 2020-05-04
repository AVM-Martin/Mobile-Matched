package id.my.avmmartin.matched.ui.account;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.ui.base.BaseActivity;

public class AccountActivity extends BaseActivity<Presenter> implements MVPView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_account);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponents() {

        ImageView ivAccount = findViewById(R.id.ivAccount);
        ivAccount.setImageResource(R.drawable.account_selected_24dp);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void setEvents() {

    }

    @Override
    protected void initPresenter() {

    }
}
