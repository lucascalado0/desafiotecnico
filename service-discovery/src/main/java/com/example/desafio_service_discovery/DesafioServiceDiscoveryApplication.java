package com.example.desafio_service_discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;




@EnableEurekaServer
@SpringBootApplication
public class DesafioServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioServiceDiscoveryApplication.class, args);
	}

}
