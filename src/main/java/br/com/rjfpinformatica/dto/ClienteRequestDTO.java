package br.com.rjfpinformatica.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequestDTO {
	
	private Long id;
	
	@NotNull(message="Nome obrigatório.")
	@NotBlank(message="Nome não pode ser vazio.")
	private String nome;
	
	@NotNull(message="CNPJ obrigatório")
	@NotBlank(message="CNPJ não pode ser vazio.")	
	private String cnpj;
	
	private String endereco;
	
	private String endereco_numero;
	
	private String endereco_complemento;
	
	private String endereco_bairro;
	
	private String endereco_cidade;
	
	private String endereco_uf;
	
	private String endereco_cep;
	
	@Email(message="E-mail inválido.")
	private String email;
}
