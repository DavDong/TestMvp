package com.blue.mvptest.model;

import com.blue.mvptest.bean.User;

/**
 * 登陆成功或者失败的回调接口
 * Created by Administrator on 2016/7/1.
 */
public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
