package org.serratec.backend.trabalho.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idPedido;

	@Column(name = "data_pedido", length = 50)
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	
	@Column(name = "status_finalizado")
	private Boolean statusFinalizado; 
	
	@OneToMany
	private List<PedidoItem> pedidoItem;
	
	@ManyToOne
	@JoinColumn(name = "cliente_pedido")
	private Cliente cliente;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Boolean getStatusFinalizado() {
		return statusFinalizado;
	}

	public void setStatusFinalizado(Boolean statusFinalizado) {
		this.statusFinalizado = statusFinalizado;
	}

	public List<PedidoItem> getPedidoItem() {
		return pedidoItem;
	}

	public void setPedidoItem(List<PedidoItem> pedidoItem) {
		this.pedidoItem = pedidoItem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
}
