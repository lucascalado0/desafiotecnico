package com.example.desafio_pedidos.client;

import com.example.desafio_pedidos.DTO.ProdutoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "PRODUTO-SERVICE")
public interface ProdutoClient {

    @GetMapping("/produtos/consultar/{id}")
    ProdutoDTO buscarProdutoPorId(@PathVariable("id") Long id);
}
