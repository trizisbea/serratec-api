package org.serratec.backend.trabalho.dto;

import java.util.Date;

import org.serratec.backend.trabalho.domain.Cliente;
import org.serratec.backend.trabalho.domain.Endereco;
import org.springframework.stereotype.Component;

@Component
public class ClienteDTO {
	

	private Long idCliente;
	private String nomeCliente;
	private String usuarioCliente;
	private String emailCliente;
	private Date nascimentoCliente;
	//private Endereco endereco;
	
	
	public ClienteDTO() {
		super();
	}
	public ClienteDTO(Cliente cliente) {
		super();
		this.idCliente = cliente.getIdCliente();
		this.nomeCliente = cliente.getNomeCliente();
		this.usuarioCliente = cliente.getUsuarioCliente();
		this.emailCliente = cliente.getEmailCliente();
		this.nascimentoCliente = cliente.getNascimentoCliente();
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
	public Date getNascimentoCliente() {
		return nascimentoCliente;
	}
	public void setNascimentoCliente(Date nascimentoCliente) {
		this.nascimentoCliente = nascimentoCliente;
	}



	
}
