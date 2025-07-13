package com.example.desafio_pedidos.Service;

import com.example.desafio_pedidos.DTO.PedidoRequest;
import com.example.desafio_pedidos.DTO.PedidoResponse;
import com.example.desafio_pedidos.DTO.ProdutoDTO;
import com.example.desafio_pedidos.client.ProdutoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final ProdutoClient produtoClient;


    public PedidoResponse simularPedido(PedidoRequest request) {

        List<ProdutoDTO> produtosCompletos = request.getItens().stream()
                .map(itemRequest -> {
                    // 2. Busca os detalhes do produto usando o client
                    ProdutoDTO produto = produtoClient.buscarProdutoPorId(itemRequest.getProdutoId());

                    if (produto != null) {
                        // 3. Adiciona a quantidade ao DTO para uso posterior no cálculo
                        produto.setQuantidade(itemRequest.getQuantidade());
                    }
                    return produto;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        // 4. Calcula o novo valor total considerando a quantidade
        BigDecimal valorTotal = produtosCompletos.stream()
                .map(produto -> produto.getPreco().multiply(BigDecimal.valueOf(produto.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Retorna a resposta
        return new PedidoResponse("PEDIDO SIMULADO COM SUCESSO", produtosCompletos, valorTotal);
    }
}