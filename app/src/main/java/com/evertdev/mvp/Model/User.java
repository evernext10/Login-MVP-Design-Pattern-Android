package com.evertdev.mvp.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User implements IUser{

    private String email, password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {
        //1. Mirar si el campo email esta en blanco
        //2. Mirar si el campo email tiene el patron de coincidencia
        //3. Mirar si el campo password sea mayor de 6 caracteres

        if(TextUtils.isEmpty(getEmail()))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if (getPassword().length() <= 6)
            return 2;
        else
            return -1;
    }
}
