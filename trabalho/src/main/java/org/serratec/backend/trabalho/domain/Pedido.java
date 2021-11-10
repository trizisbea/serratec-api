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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idPedido;

	@NotBlank(message = "Preencha a data do pedido")
	@ApiModelProperty(value = "Data do pedido", required = true)
	@Column(name = "data_pedido")
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	
	@Size(max = 50)
	@ApiModelProperty(value = "Nome do funcionário")
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
