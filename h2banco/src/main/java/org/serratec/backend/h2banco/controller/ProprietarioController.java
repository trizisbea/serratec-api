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

	
	/*@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Proprietario inserir(@RequestBody Proprietario proprietario) {
	return proprietarioRepository.save(proprietario);
	
}
	
	/*@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Proprietario> inserirVarios(@RequestBody List<Proprietario> proprietarios) {
	return proprietarioRepository.save(proprietarios);
	
}
	
	 @GetMapping
		public ResponseEntity<Proprietario> pesquisar(@PathVariable Long id) {
			Optional<Proprietario> veiculo = proprietarioRepository.findById(id);
			if (proprietario.isPresent()) {
				return ResponseEntity.ok(proprietario.get());
		}
			return ResponseEntity.notFound().build();
		 }
	
*/
}

