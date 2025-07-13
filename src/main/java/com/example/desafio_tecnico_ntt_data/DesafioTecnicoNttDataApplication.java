package com.example.desafio_tecnico_ntt_data;

import com.example.desafio_tecnico_ntt_data.Entity.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DesafioTecnicoNttDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioTecnicoNttDataApplication.class, args);

		//teste de criação de produto
		Produto produto = new Produto("Notebook", "Notebook Dell Inspiron 15", 3500.00);
		System.out.println(produto);

	}

	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer(){
		return factory -> {
			int port = 8100 + (int) (Math.random() * 100);

			factory.setPort(port);
		};
	}

}
