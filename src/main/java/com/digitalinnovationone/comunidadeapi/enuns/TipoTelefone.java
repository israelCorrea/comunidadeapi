package com.digitalinnovationone.comunidadeapi.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {

	FIXO("Fixo"),
	CELULAR("Celular"),
	SERVICO("Serviço");
	
	private final String descricao;
	
}
