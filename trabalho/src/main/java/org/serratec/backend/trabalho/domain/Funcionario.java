package org.serratec.backend.trabalho.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Long idFuncionario;
	
	@Size(max = 50)
	@ApiModelProperty(value = "Nome do funcionário")
	@Column(name = "nome_funcionario", length = 50)
	private String nomeFuncionario;
	
	@NotBlank(message = "Preencha o cpf")
	@Size(max = 11)
	@ApiModelProperty(value = "CPF", required = true)
	@CPF
	@Column(name = "cpf_funcinario", length = 11)
	private String cpfFuncionario;
	
	@OneToMany 
	private List<Produto> produto;

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getCpfFuncionario() {
		return cpfFuncionario;
	}

	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}


}
