package com.example.Oak.Tecnologia.ProvaOakTecnologia.dto;

import com.example.Oak.Tecnologia.ProvaOakTecnologia.domain.Disponibilidade;
import com.example.Oak.Tecnologia.ProvaOakTecnologia.domain.Produto;


import java.io.Serializable;

public class ProdutoDto implements Serializable {

    private Integer id;
    private String nomeProduto;
    private String descricaoProduto;
    private double valorProduto;

    private Disponibilidade disponibilidade;

    public ProdutoDto(Produto obj) {
        id = obj.getId();
        nomeProduto = obj.getNomeProduto();
        descricaoProduto = obj.getDescricaoProduto();
        valorProduto = obj.getValorProduto();
        disponibilidade = obj.getDisponibilidade();
    }

    public ProdutoDto(Integer id, String nomeProduto, String descricaoProduto, double valorProduto, Disponibilidade disponibilidade) {
    }

    public ProdutoDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}


