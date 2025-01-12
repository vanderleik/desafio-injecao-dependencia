package com.api.desafio_injecao_dependencia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioInjecaoDependenciaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioInjecaoDependenciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
	}
}
