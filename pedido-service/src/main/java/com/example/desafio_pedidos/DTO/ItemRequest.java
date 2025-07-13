package com.example.desafio_pedidos.DTO;

import lombok.Data;

@Data
public class ItemRequest {
    private Long produtoId;
    private Integer quantidade;
}
