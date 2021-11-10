package org.serratec.backend.trabalho.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class PedidoItem {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido_item")
	private Long idPedidoItem;
	
	@NotBlank(message = "Preencha a quantidade do item")
	@Size(max = 10)
	@ApiModelProperty(value = "Nome do funcionário", required = true)
	@Column(name = "quantidade_item", length = 10)
	private String quantidadeItem;
	
	@OneToOne
	@JoinColumn(name = "item")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn (name = "item_pedido")
	private PedidoItem pedidoItem;

	public Long getIdPedidoItem() {
		return idPedidoItem;
	}

	public void setIdPedidoItem(Long idPedidoItem) {
		this.idPedidoItem = idPedidoItem;
	}

	public String getQuantidadeItem() {
		return quantidadeItem;
	}

	public void setQuantidadeItem(String quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public PedidoItem getPedidoItem() {
		return pedidoItem;
	}

	public void setPedidoItem(PedidoItem pedidoItem) {
		this.pedidoItem = pedidoItem;
	}

	
}
