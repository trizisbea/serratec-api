package org.serratec.backend.trabalho.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Marca {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_marca")
	private Long idMarca;
	
	@NotBlank(message = "Preencha o nome da marca")
	@Size(max = 50)
	@ApiModelProperty(value = "Nome da marca", required = true)
	@Column(name = "nome_marca")
	private String nomeMarca;
	
	@NotBlank(message = "Preencha o CNPJ")
	@Size(max = 14)
	@ApiModelProperty(value = "CNPJ da empresa", required = true)
	@Column(name = "cnpj")
	private String cnpj;

	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	
	
	}
