package org.serratec.backend.h2banco.controller;

import java.util.List;

import java.util.Optional;

import org.serratec.backend.h2banco.domain.Proprietario;
import org.serratec.backend.h2banco.repository.ProprietarioRepository;
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
@RequestMapping("/proprietarios")
public class ProprietarioController {

	@Autowired
	private ProprietarioRepository proprietarioRepository;
	
	@GetMapping
	public ResponseEntity<List<Proprietario>> listar() {
		List<Proprietario> listaVeiculo = proprietarioRepository.findAll();
		return ResponseEntity.ok(listaVeiculo);
	}	

	/*@GetMapping("/id")
	public ResponseEntity<Proprietario> pesquisarUm(@PathVariable Long id) {
		Optional <Proprietario> Proprietario = proprietarioService.pesquisarUm(id); 
		if (Proprietario.isPresent() ) {
		return ResponseEntity.ok(Proprietario.get()); 	
		}
		return ResponseEntity.notFound().build(); 
	}*/
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Proprietario inserir(@RequestBody Proprietario proprietario) {
	return proprietarioRepository.save(proprietario);
	
}
	//retornará uma lista
	//http://localhost:8080/proprietarios/lista
	
	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Proprietario> inserirVarios(@RequestBody List<Proprietario> proprietarios) {
	return proprietarioRepository.saveAll(proprietarios);
	
}
	
	 

}

