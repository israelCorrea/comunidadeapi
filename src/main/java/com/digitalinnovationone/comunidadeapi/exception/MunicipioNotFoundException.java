package com.digitalinnovationone.comunidadeapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MunicipioNotFoundException extends Exception {

	private static final long serialVersionUID = 3645710049813545262L;

	public MunicipioNotFoundException(Long id) {
		super("Municipio não encontrado com ID " + id);
	}
}
