package org.serratec.backend.trabalho.dto;

import java.util.Date;
import java.util.List;

import org.serratec.backend.trabalho.domain.Pedido;
import org.serratec.backend.trabalho.domain.PedidoItem;
import org.springframework.stereotype.Component;

@Component
public class PedidoDTO {
	
	
	private Long idPedido;
	private Date dataPedido;
	private Boolean statusFinalizado; 
	private List<PedidoItem> pedidoItem;
	
	
	public PedidoDTO() {
		super();
	}


	public PedidoDTO(Pedido pedido) {
		super();
		this.idPedido = pedido.getIdPedido();
		this.dataPedido = pedido.getDataPedido();
		this.statusFinalizado = pedido.getStatusFinalizado();
		this.pedidoItem = pedido.getPedidoItem();
	}
		
	

}
