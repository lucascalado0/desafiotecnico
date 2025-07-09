package com.example.desafio_tecnico_ntt_data;

import com.example.desafio_tecnico_ntt_data.Entity.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioTecnicoNttDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioTecnicoNttDataApplication.class, args);

		//teste de criação de produto
		Produto produto = new Produto("Notebook", "Notebook Dell Inspiron 15", 3500.00);
		System.out.println(produto);

	}

}
