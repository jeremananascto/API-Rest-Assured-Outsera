package com.outsera.qa.tests.serverest.login.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.outsera.qa.model.LoginModel;


import java.io.FileInputStream;
import java.io.IOException;

public class LoginDataFactory {

    public static LoginModel criarLogin() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        LoginModel loginModel = objectMapper.readValue(new FileInputStream("reuqestBody/postLogin.json"), LoginModel.class);
        return loginModel;
    }

    public static LoginModel criarLoginValido() throws IOException {
        LoginModel loginValido = criarLogin();

        return loginValido;
    }

    public static LoginModel criarLoginComEmailInvalido() throws IOException {
        LoginModel loginComEmailInvalido = criarLogin();
        loginComEmailInvalido.setEmail("emailinvalido");

        return loginComEmailInvalido;
    }

    public static LoginModel criarLoginComEmailEmBranco() throws IOException {
        LoginModel loginComEmailEmBranco = criarLogin();
        loginComEmailEmBranco.setEmail("");

        return loginComEmailEmBranco;
    }

    public static LoginModel criarLoginComSenhaInvalida() throws IOException {
        LoginModel loginComSenhaInvalida = criarLogin();
        loginComSenhaInvalida.setPassword("test");

        return loginComSenhaInvalida;
    }

    public static LoginModel criarLoginComSenhaEmBranco() throws IOException {
        LoginModel loginComSenhaEmBranco = criarLogin();
        loginComSenhaEmBranco.setPassword("");

        return loginComSenhaEmBranco;
    }
}