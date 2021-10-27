package com.digitalinnovationone.comunidadeapi.utils;

import com.digitalinnovationone.comunidadeapi.dto.request.UnidadeFederativaDTO;
import com.digitalinnovationone.comunidadeapi.dto.request.UnidadeFederativaIdDTO;
import com.digitalinnovationone.comunidadeapi.entity.UnidadeFederativa;

public class UnidadeFederativaUtils {

	private static final Long UNIDADE_FEDERATIVA_ID = 1L;
	private static final String NOME = "Minas Gerais";
	private static final String SIGLA = "MG";
	
	public static UnidadeFederativaDTO createFakeDTO() {
		return UnidadeFederativaDTO.builder().
				nome(NOME).
				sigla(SIGLA).build();
	}
	
	public static UnidadeFederativaIdDTO createFakeIdDTO() {
		return UnidadeFederativaIdDTO.builder().
				id(UNIDADE_FEDERATIVA_ID).build();
	}
	
	public static UnidadeFederativa createFakeEntity() {
		return UnidadeFederativa.builder().
				id(UNIDADE_FEDERATIVA_ID).
				nome(NOME).
				sigla(SIGLA).build();
	}
	
}
