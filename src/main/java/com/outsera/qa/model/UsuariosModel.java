package com.outsera.qa.model;

import lombok.Data;

@Data
public class UsuariosModel {

    private String nome;
    private String email;
    private String password;
    private String administrador;

    public UsuariosModel(String nome, String email, String password, boolean administrador) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.administrador = Boolean.toString(administrador);
    }
}
