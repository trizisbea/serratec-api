package org.serratec.backend.exercicio02.controller;

	import java.util.ArrayList;
	import java.util.List;
	import org.serratec.backend.exercicio02.domain.Veiculo;
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
	@RequestMapping("/veiculos")
	public class VeiculoController {

		private static List <Veiculo> lista = new ArrayList<Veiculo>();

		static {
			lista.add(new Veiculo(1, "Toyota", "Etios"));
			lista.add(new Veiculo(2, "Fiat", "Weekend")); 
			lista.add(new Veiculo(3, "Renault", "Sandero")); 
			
	}
		
		@GetMapping
		public List <Veiculo> listar() {
			return lista; 
		}
		
		@PostMapping 
		//@ResponseStatus(HttpStatus.CREATED)
		//Quando der certo, retornará o status 201 - boas práticas
		public Veiculo inserir(@RequestBody Veiculo veiculo) {
			lista.add(veiculo); 
			return veiculo;
		}
		
		@DeleteMapping("{id}")
		public void delete(@PathVariable String modelo) {
			for (int i = 0; i< lista.size(); i++) {
				if(lista.get(i).getModelo().equals(modelo)) {
					lista.remove(i);
				}
				}
			}
		
		@PutMapping("modelo")
		public Veiculo atualizar(@RequestBody Veiculo veiculo, @PathVariable String modelo) {
			
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getModelo().equals(modelo)) {
					Veiculo v = new Veiculo(4, "marca x", "modelo y");
							lista.set(i, v);
					return v; 
				}
				
			}
			return null; 
		}
		}

