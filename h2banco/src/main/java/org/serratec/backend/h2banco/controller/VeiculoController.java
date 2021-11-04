package org.serratec.backend.h2banco.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.h2banco.domain.Veiculo;
import org.serratec.backend.h2banco.repository.VeiculoRepository;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository; 
	
	@GetMapping
	@ApiOperation(value = "Retorna todos os veículos cadastrados", notes = "listagem de veículos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna todos os veículos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
	})
	
	public ResponseEntity<List<Veiculo>> listar() {
		List<Veiculo> listaVeiculo = veiculoRepository.findAll();
		return ResponseEntity.ok(listaVeiculo);
	}
		
	
	 /*@GetMapping("/{id}") 
	public ResponseEntity<Veiculo> pesquisar(@PathVariable Long id) {
		Optional<Veiculo> veiculo = veiculoRepository.findById(id);
		if (veiculo.isPresent()) {
			return ResponseEntity.ok(veiculo.get());
	}
		return ResponseEntity.notFound().build();
	 }*/
	 
	 
	  @PutMapping("/{id}")
	  @ApiOperation(value = "Atualiza veículo cadastrado", notes = "atualizar veículos")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Veículo atualizado"),
				@ApiResponse(code = 201, message = "Veículo criado"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso não encontrado"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
		})
	  public ResponseEntity<Veiculo> atualizar(@Valid @RequestBody Veiculo veiculo, @PathVariable Long id) {
		if (!veiculoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		veiculo.setId(id); 
		veiculo = veiculoRepository.save(veiculo);
		return ResponseEntity.ok(veiculo);
	
	  }

	
	@PostMapping
	@ApiOperation(value = "Cadastra veículo", notes = "listagem de veículos")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Veículo adicionado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
	})
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo inserir(@Valid @RequestBody Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	
}
	
	
	 @DeleteMapping("/{id}")
	 @ApiOperation(value = "Remove veículo cadastrado", notes = "remover veículo")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Veículo removido"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso não encontrado"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
		})
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!veiculoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		veiculoRepository.deleteById(id); 
		return ResponseEntity.noContent().build();
		
	}


}
