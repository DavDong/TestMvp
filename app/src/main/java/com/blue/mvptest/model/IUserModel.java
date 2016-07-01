package com.blue.mvptest.model;

/**
 * Created by Administrator on 2016/7/1.
 */
public interface IUserModel {
    void login(String username, String password,OnLoginListener onLoginListener);
}
