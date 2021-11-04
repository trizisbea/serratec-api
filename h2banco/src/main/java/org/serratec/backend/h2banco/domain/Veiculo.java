package org.serratec.backend.h2banco.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Identificador do veículo")
	private Long id; 
	
	@NotBlank(message = "Preencha a placa")
	@Size(max = 7)
	@Column(nullable = false, length = 7)
	@ApiModelProperty(value = "Placa do veículo", required = true)
	private String placa; 
	
	@NotBlank(message = "Preencha a marca")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	@ApiModelProperty(value = "Marca do veículo", required = true)
	private String marca; 
	
	@NotBlank(message = "Preencha o modelo")
	@Size(max = 40)
	@Column(nullable = false, length = 40)
	@ApiModelProperty(value = "Modelo do veículo", required = true)
	private String modelo; 
	
	@Embedded 
	//tabela Veiculo deve conter os campos de Caracteristica no banco de dados
	//cria-se classes distintas, mas os atributos vão todos para a mesma tabela (a que contém o embedded)
	@ApiModelProperty(value = "Características do veículo")
	private Caracteristica caracteristica;
	
	
	@OneToOne
	//indica o tipo de relacionamento entre classes
	@JoinColumn(name = "id_proprietario")
	@ApiModelProperty(value = "Identificador de proprietário - fk")
	private Proprietario proprietario; 
	//indica a presença de uma fk - liga a tabela Proprietario a tabela Veiculo
	
	
	@OneToMany(mappedBy = "veiculo")
	//indica o tipo de relacionamento entre classes
	@ApiModelProperty(value = "Lista de manutenções")
	private List<Manutencao> manutencoes; 
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public List<Manutencao> getManutencoes() {
		return manutencoes;
	}

	public void setManutencoes(List<Manutencao> manutencoes) {
		this.manutencoes = manutencoes;
	} 
	
	
}
