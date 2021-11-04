package org.serratec.backend.h2banco.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.h2banco.domain.Manutencao;
import org.serratec.backend.h2banco.repository.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {
	
	@Autowired 
	private ManutencaoRepository manutencaoRepository;
	
	@GetMapping
	public ResponseEntity<List<Manutencao>> listar() {
		List<Manutencao> listaVeiculo = manutencaoRepository.findAll();
		return ResponseEntity.ok(listaVeiculo);
	}
		
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Manutencao inserir(@Valid @RequestBody Manutencao manutencao) {
		return manutencaoRepository.save(manutencao);
	
}
	
	
}
