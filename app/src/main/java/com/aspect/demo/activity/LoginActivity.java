package com.aspect.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.aspect.demo.R;
import com.aspect.demo.presenter.BasePresenter;
import com.aspect.demo.presenter.LoginPresenter;
import com.aspect.demo.utils.Util;
import com.aspect.demo.view.LoginView;

import com.annotation.BindView;


/**
 * Created by Administrator on 2017/8/3.
 */

public class LoginActivity extends BaseActivity implements LoginView{

    @BindView(R.id.login_layout_name)
    EditText login_name_edit;

    @BindView(R.id.login_layout_pwd)
    EditText login_pwd_edit;

    @BindView(R.id.login_layout_login)
    Button login_pwd_btn;

    private LoginPresenter basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        login_pwd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = login_name_edit.getText().toString();
                String pass = login_pwd_edit.getText().toString();
                String msg = TextUtils.isEmpty(name) ? "用户名不能为空!" : TextUtils.isEmpty(pass) ? "密码不能为空!" : "";
                if (!TextUtils.isEmpty(msg)) Util.showToast(LoginActivity.this,msg);
                basePresenter.login(name,pass);
            }
        });
        new LoginPresenter(this);
    }

    @Override
    public void setPresenter(BasePresenter basePresenter) {
        this.basePresenter = (LoginPresenter) basePresenter;
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void loginResult(int code) {
        switch (code){
            case 0:
                Util.showToast(this,"登录成功");
                break;
            default:
                Util.showToast(this,"登录失败");
                break;
        }
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}
