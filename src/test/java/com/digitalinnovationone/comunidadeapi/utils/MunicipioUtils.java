package com.digitalinnovationone.comunidadeapi.utils;

import com.digitalinnovationone.comunidadeapi.dto.request.MunicipioDTO;
import com.digitalinnovationone.comunidadeapi.dto.request.MunicipioIdDTO;
import com.digitalinnovationone.comunidadeapi.entity.Municipio;

public class MunicipioUtils {

	private static final Long MUNICIPIO_ID = 1L;
	private static final String NOME = "Belo Horizonte";
	
	public static MunicipioDTO createFakeDTO() {
		return MunicipioDTO.builder().
				nome(NOME).
				unidadeFederativa(UnidadeFederativaUtils.createFakeIdDTO()).
				build();
	}
	
	public static MunicipioIdDTO createFakeIdDTO() {
		return MunicipioIdDTO.builder().
				id(MUNICIPIO_ID).
				build();
	}
	
	public static Municipio createFakeEntity() {
		return Municipio.builder().
				id(MUNICIPIO_ID).
				nome(NOME).
				unidadeFederativa(UnidadeFederativaUtils.createFakeEntity()).build();
	}
	
}
