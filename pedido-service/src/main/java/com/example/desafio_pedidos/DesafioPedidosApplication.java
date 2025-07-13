package com.example.desafio_pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class DesafioPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPedidosApplication.class, args);
	}
}
