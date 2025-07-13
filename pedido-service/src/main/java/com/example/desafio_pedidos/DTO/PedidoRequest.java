package com.example.desafio_pedidos.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PedidoRequest {
    private List<ItemRequest> itens;

}
