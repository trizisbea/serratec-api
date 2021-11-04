package org.serratec.backend.h2banco.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.h2banco.domain.Funcionario;
import org.serratec.backend.h2banco.repository.FuncionarioRepository;
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
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	 
	@Autowired
	private FuncionarioRepository funcionarioRepository; 
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> listar() {
		List<Funcionario> listaFuncionario = funcionarioRepository.findAll();
		return ResponseEntity.ok(listaFuncionario);
	}
	

	  @PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizar(@Valid @RequestBody Funcionario funcionario, @PathVariable Long id) {
		if (!funcionarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		funcionario.setId(id); 
		funcionario = funcionarioRepository.save(funcionario);
		return ResponseEntity.ok(funcionario);
	
	  }

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario inserir(@Valid @RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	
}
	
	
	 @DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!funcionarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		funcionarioRepository.deleteById(id); 
		return ResponseEntity.noContent().build();
		
	}

	 

}
