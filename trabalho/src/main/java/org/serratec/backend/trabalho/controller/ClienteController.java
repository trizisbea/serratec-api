package org.serratec.backend.trabalho.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.trabalho.domain.Categoria;
import org.serratec.backend.trabalho.domain.Cliente;
import org.serratec.backend.trabalho.dto.ClienteDTO;
import org.serratec.backend.trabalho.repository.ClienteRepository;
import org.serratec.backend.trabalho.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController 
@RequestMapping("/clientes")
public class ClienteController {
	
	//PUT, POST e GET por id 
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository; 
	
	@Autowired
	private ClienteDTO clienteDTO; 
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> pesquisarTodos() {
		return ResponseEntity.ok(clienteService.pesquisarTodos());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Cliente> pesquisarUm(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
	}
		return ResponseEntity.notFound().build();		

}

	
	@PostMapping
	public ResponseEntity<Cliente> inserir(@Valid @RequestBody Cliente cliente, UriComponentsBuilder b) {
		Cliente client = clienteService.inserir(cliente);
		UriComponents uriComponents = b.path("/clientes/{id}").buildAndExpand(cliente);
		return ResponseEntity.created(uriComponents.toUri()).body(cliente);
	}
	
	
	
	
	@PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> editar(@Valid @RequestBody Cliente cliente, @PathVariable Long id) {
        if (!clienteService.idExiste(id)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setIdCliente(id);
        cliente = clienteService.inserir(cliente);
        ClienteDTO cDto = new ClienteDTO(cliente);
        return ResponseEntity.ok(cDto);
    }

}
