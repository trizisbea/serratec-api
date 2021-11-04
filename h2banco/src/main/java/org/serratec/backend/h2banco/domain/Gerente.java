package org.serratec.backend.h2banco.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Gerente extends Funcionario {
	
	@Column
	private String setor;

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	} 

	
}
