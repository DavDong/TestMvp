package com.blue.mvptest.model;

import com.blue.mvptest.bean.User;

/**
 * Created by Administrator on 2016/7/1.
 */
public class UserModel implements IUserModel {
    private User user;

    @Override
    public void login(final String username, final String password, final OnLoginListener onLoginListener) {
        new Thread(){
            @Override
            public void run(){

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("dong".equals(username)&& "123".equals(password)){
                    user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    onLoginListener.loginSuccess(user);
                }else {
                    onLoginListener.loginFailed();
                }
            }
        }.start();
    }
}
