package com.blue.mvptest.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.blue.mvptest.R;
import com.blue.mvptest.bean.User;
import com.blue.mvptest.presenter.UserLoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IUserView{

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @BindView(R.id.et1)
    EditText et1;

    @BindView(R.id.et2)
    EditText et2;

    @BindView(R.id.pb)
    ProgressBar pb;

    @OnClick(R.id.bt_login) void login(){
        mUserLoginPresenter.login();
    }
    @OnClick(R.id.bt_cancel) void clear(){
        mUserLoginPresenter.clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }



    @Override
    public String getUserName() {
        return et1.getText().toString();
    }

    @Override
    public String getPassword() {
        return et2.getText().toString();
    }

    @Override
    public void clearUserName() {
        et1.setText("");
    }

    @Override
    public void clearPassWord() {
        et2.setText("");
    }

    @Override
    public void showDialog() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this,user.getUsername(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,"error",Toast.LENGTH_SHORT).show();
    }
}
