package com.example.desafio_pedidos.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class PedidoResponse {

    private String status;
    private List<ProdutoDTO> produtos;
    private BigDecimal total;
}
