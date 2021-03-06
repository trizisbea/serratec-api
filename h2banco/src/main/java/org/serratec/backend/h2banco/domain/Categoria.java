package org.serratec.backend.h2banco.domain;

import org.serratec.backend.h2banco.exception.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Categoria {
	
	HATCH, SEDAN, PICAPE, SUV, CONVERSIVEL, MINIVAN;
	//criação de ENUM para facilitar a validação
	
	
	//Exception ENUM
	@JsonCreator
	public static Categoria verifica(String value) throws EnumValidationException {
		for (Categoria c : values()) {
			if (value.equals(c.name())) {
				return c;
			}
		}
		throw new EnumValidationException("Categoria Preenchida incorretamente");
	}
}

	
	




