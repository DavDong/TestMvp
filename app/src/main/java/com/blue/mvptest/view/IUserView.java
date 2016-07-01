package com.blue.mvptest.view;

import com.blue.mvptest.bean.User;

/**
 * Created by Administrator on 2016/7/1.
 */
public interface IUserView {
    String getUserName();
    String getPassword();
    void clearUserName();
    void clearPassWord();
    //加载动画
    void showDialog();
    void hideDialog();
    //成功和失败的处理
    void toMainActivity(User user);
    void showFailedError();
}
