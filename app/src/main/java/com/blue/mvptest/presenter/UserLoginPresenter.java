package com.blue.mvptest.presenter;

import android.os.Handler;

import com.blue.mvptest.bean.User;
import com.blue.mvptest.model.IUserModel;
import com.blue.mvptest.model.OnLoginListener;
import com.blue.mvptest.model.UserModel;
import com.blue.mvptest.view.IUserView;


/**
 * Created by Administrator on 2016/7/1.
 */
public class UserLoginPresenter {
    private IUserView userView;
    private IUserModel userModel;
    private Handler handler = new Handler();
    /**
     * 连接view和model
     * @param userView
     */
    public UserLoginPresenter(IUserView userView){
        this.userView = userView;
        this.userModel = new UserModel();

    }
    //具体的登陆逻辑
    public void login(){
        userView.showDialog();
        userModel.login(userView.getUserName(), userView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.toMainActivity(user);
                        userView.hideDialog();
                    }
                });
            }

            @Override
            public void loginFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.showFailedError();
                        userView.hideDialog();
                    }
                });
            }
        });
    }

    public void clear(){
        userView.clearPassWord();
        userView.clearUserName();
    }
}
