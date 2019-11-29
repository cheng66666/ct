package com.example.administrator.ct.activity;

import android.text.TextUtils;
import android.widget.EditText;

import com.example.administrator.ct.R;
import com.example.administrator.ct.common.BaseActivity;
import com.example.administrator.ct.http.ProgressDialogSubscriber;
import com.example.administrator.ct.http.entity.MemberEntity;
import com.example.administrator.ct.http.presenter.MemberPresenter;
import com.example.administrator.ct.utils.SystemConfig;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_pwd)
    EditText etPwd;

    @Override
    public int getContentViewId(){
        return R.layout.activity_login;
    }

    @OnClick(R.id.iv_back)
    void close(){
        finish();
    }

    @OnClick(R.id.bt_login)
    void login(){
        String username = etUsername.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();
        if(TextUtils.isEmpty(username)){
            toastShort("请输入用户名");
            return;
        }
        if(TextUtils.isEmpty(pwd)){
            toastShort("请输入密码");
            return;
        }
        MemberPresenter.login2(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                //保留登录状态
                SystemConfig.setLogin(true);
                //弹出登陆成功提示
                toastShort("登陆成功");
                SystemConfig.setLoginUserName(memberEntity.uname);
                SystemConfig.setLoginUserEmail(memberEntity.email);
                SystemConfig.setLoginUserHead(memberEntity.image);
                setResult(RESULT_OK);
                finish();
            }
        },username,pwd);
    }

}
