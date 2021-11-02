package org.serratec.java2backend.exercicio02.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.java2backend.exercicio02.domain.Cliente;
import org.serratec.java2backend.exercicio02.repository.ClienteRepository;
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
	public Cliente inserir(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);	
}
	
	/*@PostMapping
	public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
	return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	
	}
	não está funcionando
	*/
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@Valid @RequestBody Cliente cliente, @PathVariable Long id) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(id); //se não for setado o id, será criado outro objeto
		cliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	
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
