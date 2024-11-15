package br.com.rjfpinformatica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rjfpinformatica.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findByNome(String nome);
	
	List<Cliente> findByCnpj(String cnpj);
	
	List<Cliente> findByEmail(String email);
}
