package com.evertdev.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.evertdev.mvp.Presenter.ILoginPresenter;
import com.evertdev.mvp.Presenter.LoginPresenter;
import com.evertdev.mvp.View.ILoginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginView{

    EditText edt_email, edt_password;
    Button btnLogin;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnLogin = (Button) findViewById(R.id.btn_login);
        edt_email = (EditText)findViewById(R.id.edt_email);
        edt_password = (EditText)findViewById(R.id.edt_password);

        loginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLogin(edt_email.getText().toString(),edt_password.getText().toString());
            }
        });
    }


    @Override
    public void onLoginSucces(String message) {
        Toasty.success(getApplicationContext(), message,Toast.LENGTH_SHORT);
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(getApplicationContext(), message,Toast.LENGTH_SHORT);
    }
}
