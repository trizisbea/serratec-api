package org.serratec.backend.trabalho.domain;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long idCliente;
	
	@Column(name = "nome_cliente", length = 50)
	private String nomeCliente;
	
	@Column(name = "usuario_cliente", length = 50)
	private String usuarioCliente;
	
	@Email
	@Column(name = "email_cliente", length = 50)
	private String emailCliente;
	
	@CPF
	@Column(name = "cpf_cliente", length = 11)
	private String cpfCliente;
	
	@Column(name = "nascimento_cliente")
	@Temporal(TemporalType.DATE)
	private Date nascimentoCliente;
	
	@OneToMany
	private List <Endereco> endereco; 
	
	@Column(name = "senha", length = 20)
	private String senha;
	
	@OneToMany
	private List <Pedido> pedido;
	

	public Cliente() {
		super();
	}
	
	public Long getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getUsuarioCliente() {
		return usuarioCliente;
	}


	public void setUsuarioCliente(String usuarioCliente) {
		this.usuarioCliente = usuarioCliente;
	}


	public String getEmailCliente() {
		return emailCliente;
	}


	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}


	public String getCpfCliente() {
		return cpfCliente;
	}


	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}


	public Date getNascimentoCliente() {
		return nascimentoCliente;
	}


	public void setNascimentoCliente(Date nascimentoCliente) {
		this.nascimentoCliente = nascimentoCliente;
	}


	public List<Endereco> getEndereco() {
		return endereco;
	}


	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public List<Pedido> getPedido() {
		return pedido;
	}


	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}


}