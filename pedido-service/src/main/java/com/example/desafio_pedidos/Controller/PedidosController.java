package com.example.desafio_pedidos.Controller;

import com.example.desafio_pedidos.DTO.PedidoRequest;
import com.example.desafio_pedidos.DTO.PedidoResponse;
import com.example.desafio_pedidos.Service.PedidoService;
import com.netflix.discovery.converters.Auto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/pedidos")
@RequiredArgsConstructor
public class PedidosController {


    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponse> simularPedido(@RequestBody PedidoRequest request){

        PedidoResponse pedidoResponse = pedidoService.simularPedido(request);

        return ResponseEntity.ok(pedidoResponse);
    }
}
