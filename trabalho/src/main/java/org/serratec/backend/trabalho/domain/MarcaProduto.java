package org.serratec.backend.trabalho.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class MarcaProduto {
	
	@EmbeddedId
	private MarcaProdutoPK id = new MarcaProdutoPK();
	
	@Column(name = "codigo_barras")
	private String codigoBarras;

	public MarcaProduto() {
		super();
	}

	public MarcaProduto(Marca marca, Produto produto, String codigoBarras) {
		super();
		id.setMarca(marca);
		id.setProduto(produto);
		this.codigoBarras = codigoBarras;
	}

	public MarcaProdutoPK getId() {
		return id;
	}

	public void setId(MarcaProdutoPK id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	
	

}
