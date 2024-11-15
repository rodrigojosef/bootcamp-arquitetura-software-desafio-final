package br.com.rjfpinformatica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cliente")
@Getter
@Setter
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Nome obrigatório")
	@NotBlank(message="Nome obrigatório")
	private String nome;
	private String cnpj;
	private String endereco;
	private String endereco_numero;
	private String endereco_complemento;
	private String endereco_bairro;
	private String endereco_cidade;
	private String endereco_uf;
	private String endereco_cep;
	private String email;
}