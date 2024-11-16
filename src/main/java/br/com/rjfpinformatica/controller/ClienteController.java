package br.com.rjfpinformatica.controller;

import java.util.ArrayList;
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

import br.com.rjfpinformatica.dto.ClienteRequestDTO;
import br.com.rjfpinformatica.dto.ClienteResponseDTO;
import br.com.rjfpinformatica.exception.CustomNotFoundException;
import br.com.rjfpinformatica.model.Cliente;
import br.com.rjfpinformatica.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private final ClienteService clienteService;
	
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<ClienteResponseDTO> listarTodos() {
		List<Cliente> listClientes = clienteService.listarTodos();
		List<ClienteResponseDTO> listClienteResponseDTO = new ArrayList<>();
		
		listClientes.stream().forEach(cliente -> {
			ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
			modelMapper.map(cliente, clienteResponseDTO);
			listClienteResponseDTO.add(clienteResponseDTO);
		});
		
		return listClienteResponseDTO; 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long id) {
		return clienteService.buscarPorId(id)
	                         .map(cliente -> {
	                        	 ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
	                        	 modelMapper.map(cliente, clienteResponseDTO);
	                        	 return ResponseEntity.ok(clienteResponseDTO);
	                         })
	                         .orElseThrow(() -> new CustomNotFoundException("Cliente "+id+" não encontrado."));
	}
	
	@GetMapping("/nome/{nome}")
	public List<ClienteResponseDTO> buscarPorNome(@PathVariable String nome) {
		List<Cliente> listClientes = clienteService.buscarPorNome(nome);
		List<ClienteResponseDTO> listClienteResponseDTO = new ArrayList<>();
		
		listClientes.stream().forEach(cliente -> {
			ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
			modelMapper.map(cliente, clienteResponseDTO);
			listClienteResponseDTO.add(clienteResponseDTO);
		});
		
		return listClienteResponseDTO;		
	}
	
	@GetMapping("/cnpj/{cnpj}")
	public List<ClienteResponseDTO> buscarPorCnpj(@PathVariable String cnpj) {
		List<Cliente> listClientes = clienteService.buscarPorCnpj(cnpj);
		List<ClienteResponseDTO> listClienteResponseDTO = new ArrayList<>();
		
		listClientes.stream().forEach(cliente -> {
			ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
			modelMapper.map(cliente, clienteResponseDTO);
			listClienteResponseDTO.add(clienteResponseDTO);
		});
		
		return listClienteResponseDTO;		
	}
	
	@GetMapping("/email/{email}")
	public List<ClienteResponseDTO> buscarPorEmail(@PathVariable String email) {
		List<Cliente> listClientes = clienteService.buscarPorEmail(email);
		List<ClienteResponseDTO> listClienteResponseDTO = new ArrayList<>();
		
		listClientes.stream().forEach(cliente -> {
			ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
			modelMapper.map(cliente, clienteResponseDTO);
			listClienteResponseDTO.add(clienteResponseDTO);
		});
		
		return listClienteResponseDTO;		
	}
	
	@GetMapping("/contar")
	public long contarClientes() {
		return clienteService.contarClientes();
	}
	
	@PostMapping
	public ClienteResponseDTO inserir(@Valid @RequestBody ClienteRequestDTO clienteDTO) {
		Cliente cliente = new Cliente();
		modelMapper.map(clienteDTO, cliente);
		cliente = clienteService.salvar(cliente);
		
		ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
		modelMapper.map(cliente, clienteResponseDTO);
		
		return clienteResponseDTO;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteResponseDTO> deletar(@PathVariable Long id) {
		return clienteService.buscarPorId(id)
                .map(cliente -> {
                	clienteService.deletar(id);
            		
                	ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
            		modelMapper.map(cliente, clienteResponseDTO);
                	
                	return ResponseEntity.ok(clienteResponseDTO);
                })
                .orElseThrow(() -> new CustomNotFoundException("Cliente "+id+" não encontrado."));
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteRequestDTO clienteDTO) {
        return clienteService.buscarPorId(id)
                .map(cliente -> {
                	clienteDTO.setId(id);
                	modelMapper.map(clienteDTO, cliente);
                	clienteService.salvar(cliente);
            		
                	ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
            		modelMapper.map(cliente, clienteResponseDTO);
                	
                	return ResponseEntity.ok(clienteResponseDTO);
                })
                .orElseThrow(() -> new CustomNotFoundException("Cliente "+id+" não encontrado."));
    }
}
