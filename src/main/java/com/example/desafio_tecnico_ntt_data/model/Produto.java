package com.example.desafio_tecnico_ntt_data.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity(name = "produto")
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 200)
    private String descricao;

    @Column(nullable = false)
    private double preco;

    public Produto(String nome, String descricao, double preco){
        this.nome = nome;
        this.descricao = descricao;
        if(preco < 0) {
            throw new IllegalArgumentException("O preço do produto não pode ser negativo.");
        } else {
            this.preco = preco;
        }
    }
}
