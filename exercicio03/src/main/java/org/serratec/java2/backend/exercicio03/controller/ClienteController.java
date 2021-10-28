package org.serratec.java2.backend.exercicio03.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.java2.backend.exercicio03.domain.Cliente;
import org.serratec.java2.backend.exercicio03.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	
	//injeção de dependência 
	@Autowired
	private ClienteRepository clienteRepository;  
	
	//Métodos get, get por id, post, put, delete 
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> listaCliente = clienteRepository.findAll();
		return ResponseEntity.ok(listaCliente);
	}
		
	@GetMapping("/{id}") 
	public ResponseEntity<Cliente> pesquisar(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
	}
		return ResponseEntity.notFound().build();		

}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente inserir(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	
}
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente produto, @PathVariable Long id) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		produto.setId(id);
		produto = clienteRepository.save(produto);
		return ResponseEntity.ok(produto);
	
}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(id); 
		return ResponseEntity.noContent().build();
		
	}

}
