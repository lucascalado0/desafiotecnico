package com.example.desafio_pedidos.DTO;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private int quantidade;
}
