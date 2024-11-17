package br.com.rjfpinformatica.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	@Bean
	OpenAPI openAPI() {
	  return new OpenAPI()
	          .info(new Info()
	                  .title("Desafio Final - API REST")
	                  .description("Bootcamp Arquitetura de Software - Aluno: Rodrigo José Ferreira Pinto")
	                  .version("1.0")
	          );
	}
}