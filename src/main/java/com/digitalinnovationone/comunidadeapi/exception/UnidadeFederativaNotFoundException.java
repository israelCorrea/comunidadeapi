package com.digitalinnovationone.comunidadeapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UnidadeFederativaNotFoundException extends Exception {

	private static final long serialVersionUID = 971441468263631501L;

	public UnidadeFederativaNotFoundException(Long id) {
		super("Unidade Federativa não encontrada com ID " + id);
	}
}
