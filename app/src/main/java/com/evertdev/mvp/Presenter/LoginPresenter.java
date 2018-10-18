package com.evertdev.mvp.Presenter;

import com.evertdev.mvp.Model.User;
import com.evertdev.mvp.View.ILoginView;

public class LoginPresenter implements ILoginPresenter{

    ILoginView loginView;


    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email,password);
        int loginCode = user.isValidData();

        if(loginCode == 0)
            loginView.onLoginError("Login Error");
        else if(loginCode == 1)
            loginView.onLoginError("Login Error");
        else if(loginCode == 2)
            loginView.onLoginError("Password leng must be greater than 6");
        else
            loginView.onLoginSucces("Login success");
    }
}
