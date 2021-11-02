package org.serratec.java2backend.exercicio02.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;
	
	@Size(max = 60, message = "O tamanho máximo é 60")
	@Column(name = "nome", length = 60)
	private String nome; 
	
	@CPF
	@NotBlank(message = "Favor preencher o nome")
	@Column(name = "cpf", length = 11)
	private String cpf;
	
	@Email
	@NotBlank(message = "Favor preencher o e-mail")
	@Column(name = "email", length = 50)
	private String email;
	
	//está dando erro ao colocar not blank
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	} 
	
}

