package org.serratec.java2.backend.exercicio03.repositorio;

import org.serratec.java2.backend.exercicio03.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}
