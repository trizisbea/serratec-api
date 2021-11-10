package org.serratec.backend.trabalho.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long idProduto;
	
	@NotBlank(message = "Preencha o nome do produto")
	@Size(max = 50)
	@ApiModelProperty(value = "Nome do produto", required = true)
	@Column(name = "nome_produto")
	private String nomeProduto;
	
	@Size(max = 50)
	@ApiModelProperty(value = "Descrição do produto")
	@Column(name = "descricao_produto")
	private String descricaoProduto;
	
	@NotBlank(message = "Preencha a quantidade do estoque")
	@Size(max = 10)
	@ApiModelProperty(value = "Quantidade do estoque", required = true)
	@Column(name = "estoque")
	private int estoque;
	
	@NotBlank(message = "Preencha o valor do produto")
	@Size(max = 10)
	@ApiModelProperty(value = "Valor do produto", required = true)
	@Column(name = "valor")
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name = "categoria_produto")
	private Categoria categoria; 
	
	@ManyToOne
	@JoinColumn(name = "inserido_por")
	private Funcionario funcionario;


	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


}
