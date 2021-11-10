package org.serratec.backend.trabalho.repository;

import org.serratec.backend.trabalho.domain.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

}