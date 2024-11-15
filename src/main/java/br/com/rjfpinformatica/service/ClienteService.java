package br.com.rjfpinformatica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rjfpinformatica.model.Cliente;
import br.com.rjfpinformatica.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll(); 
	}
	
	public Optional<Cliente> buscarPorId(Long id) {
		return clienteRepository.findById(id); 
	}
	
	public List<Cliente> buscarPorNome(String nome) { 
		return clienteRepository.findByNome(nome); 
	}
	
	public List<Cliente> buscarPorCnpj(String cnpj) { 
		return clienteRepository.findByCnpj(cnpj); 
	}
	
	public List<Cliente> buscarPorEmail(String email) { 
		return clienteRepository.findByEmail(email); 
	}
	
	public Cliente salvar(Cliente cliente) { 
		return clienteRepository.save(cliente); 
	}
	
	public void deletar(Long id) {
		clienteRepository.deleteById(id); 
	}
	
	public long contarClientes() {
		return clienteRepository.count();
	}
}