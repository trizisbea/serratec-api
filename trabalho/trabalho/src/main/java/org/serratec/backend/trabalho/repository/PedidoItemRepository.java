package org.serratec.backend.trabalho.repository;

import java.math.BigDecimal;
import org.serratec.backend.trabalho.domain.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

	
	@Repository
	public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long>   {

	    /*@Query(value = "SELECT sum(quantidadeItem) FROM PedidoItem")
	    public Long sumQuantities();

	    @Query(value = "SELECT sum(quantidadeItem * valor) FROM PedidoItem p where p.pedido.idPedido = :idPedido")
	    public Double total(Long idPedido);*/

	}
