package br.com.rjfpinformatica.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponseDTO {
	
	private Long id;
	private String cnpj;
	private String nome;
	private String email;
}