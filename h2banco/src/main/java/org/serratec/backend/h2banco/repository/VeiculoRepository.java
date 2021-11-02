package org.serratec.backend.h2banco.repository;

import org.serratec.backend.h2banco.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
}

