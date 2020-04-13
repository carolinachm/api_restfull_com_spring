package br.com.springboot.cursospring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.springboot.utils.SenhaUtils;

@SpringBootApplication
public class DemoApplication {
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	/**
	 * Executar um codigo assim qdo aplicação for carregada
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			String senhaEncoded = SenhaUtils.gerarBCrypt("123456");
			System.out.println("Senha encoded:" + senhaEncoded);

			senhaEncoded = SenhaUtils.gerarBCrypt("123456");
			System.out.println("Senha Encoded novamente: " + senhaEncoded);

			System.out.println("Senha valida:" + SenhaUtils.senhaValida("123456", senhaEncoded));
		};
	}

}
