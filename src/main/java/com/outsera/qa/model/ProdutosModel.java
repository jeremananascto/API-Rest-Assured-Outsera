package com.outsera.qa.model;

import lombok.Data;

@Data
public class ProdutosModel {

    private String nome;
    private int preco;
    private String descricao;
    private int quantidade;

    public ProdutosModel(String nome, int preco, String descricao, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
}
