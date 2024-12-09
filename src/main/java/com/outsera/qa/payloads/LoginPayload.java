package com.outsera.qa.payloads;

import com.google.gson.Gson;
import com.outsera.qa.model.LoginModel;


public class LoginPayload {

    public static String toJson(String email, String password) {
        LoginModel login = new LoginModel(email, password);
        return new Gson().toJson(login);
    }

}
