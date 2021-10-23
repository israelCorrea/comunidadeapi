package com.digitalinnovationone.comunidadeapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MembroNotFoundException extends Exception {

	private static final long serialVersionUID = 3645710049813545262L;

	public MembroNotFoundException(Long id) {
		super("Membro não encontrado com ID " + id);
	}
}
