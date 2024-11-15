package br.com.rjfpinformatica.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rjfpinformatica.model.Cliente;
import br.com.rjfpinformatica.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<Cliente> listarTodos() {
		return clienteService.listarTodos(); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
		return clienteService.buscarPorId(id)
	                         .map(ResponseEntity::ok)
	                         .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public List<Cliente> buscarPorNome(@PathVariable String nome) {
		return clienteService.buscarPorNome(nome);
	}
	
	@GetMapping("/cnpj/{cnpj}")
	public List<Cliente> buscarPorCnpj(@PathVariable String cnpj) {
		return clienteService.buscarPorCnpj(cnpj);
	}
	
	@GetMapping("/email/{email}")
	public List<Cliente> buscarPorEmail(@PathVariable String email) {
		return clienteService.buscarPorEmail(email);
	}
	
	@GetMapping("/contar")
	public long contarClientes() {
		return clienteService.contarClientes();
	}
	
	@PostMapping
	public Cliente inserir(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		clienteService.deletar(id);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente clienteRequestBody) {
        return clienteService.buscarPorId(id)
                .map(cliente -> {
                	clienteRequestBody.setId(id);
                	modelMapper.map(clienteRequestBody, cliente);
                    return ResponseEntity.ok(clienteService.salvar(cliente));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
