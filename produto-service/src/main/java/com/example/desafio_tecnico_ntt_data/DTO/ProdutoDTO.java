package com.example.desafio_tecnico_ntt_data.DTO;

import com.example.desafio_tecnico_ntt_data.Entity.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProdutoDTO {

    private Long idProduto;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @Positive(message = "O preço deve ser maior que zero")
    private double preco;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Long idProduto, String nome, String descricao, double preco) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public ProdutoDTO(Produto produto){
        this.idProduto = produto.getIdProduto();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produto toEntity(){
        return new Produto(this.nome, this.descricao, this.preco);
    }
}
