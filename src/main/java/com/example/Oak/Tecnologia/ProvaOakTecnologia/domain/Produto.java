package com.example.Oak.Tecnologia.ProvaOakTecnologia.domain;

import jakarta.persistence.*;


import java.io.Serializable;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeProduto;
    private String descricaoProduto;
    private double valorProduto;
    @Enumerated(EnumType.STRING)
    private Disponibilidade disponibilidade;


    public Produto() {
    }

    public Produto(Integer id, String nomeProduto, String descricaoProduto, double valorProduto, Disponibilidade disponibilidade) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorProduto = valorProduto;
        this.disponibilidade = disponibilidade;
    }

    public Integer getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
