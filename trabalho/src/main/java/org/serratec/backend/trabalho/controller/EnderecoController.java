package org.serratec.backend.trabalho.controller;


import org.serratec.backend.trabalho.domain.Endereco;
import org.serratec.backend.trabalho.repository.EnderecoRepository;
import org.serratec.backend.trabalho.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping("{cep}")
	public ResponseEntity<Endereco> buscar(@PathVariable String cep) {
		Endereco endereco = enderecoService.buscar(cep);
		
		if (endereco == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(endereco);
		}
}
}