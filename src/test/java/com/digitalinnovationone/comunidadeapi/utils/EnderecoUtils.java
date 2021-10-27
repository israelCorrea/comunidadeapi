package com.digitalinnovationone.comunidadeapi.utils;

import com.digitalinnovationone.comunidadeapi.dto.request.EnderecoDTO;
import com.digitalinnovationone.comunidadeapi.entity.Endereco;
import com.digitalinnovationone.comunidadeapi.enuns.TipoLogradouro;

public class EnderecoUtils {

	private static final String LOGRADOURO = "rua Belo Horizonte";
	private static final String COMPLEMENTO = "CASA A";
	private static final String NUMERO = "789";
	private static final String BAIRRO = "Centro";
	private static final String CEP = "31578-789";
	
	public static EnderecoDTO createFakeDTO() {
		return EnderecoDTO.builder().
				tipoLogradouro(TipoLogradouro.RUA).
				logradouro(LOGRADOURO).
				complemento(COMPLEMENTO).
				numero(NUMERO).
				bairro(BAIRRO).
				cep(CEP).
				municipio(MunicipioUtils.createFakeIdDTO()).
				unidadeFederativa(UnidadeFederativaUtils.createFakeIdDTO()).
				build();
	}
	
	public static Endereco createFakeEntity() {
		return Endereco.builder().
				tipoLogradouro(TipoLogradouro.RUA).
				logradouro(LOGRADOURO).
				complemento(COMPLEMENTO).
				numero(NUMERO).
				bairro(BAIRRO).
				cep(CEP).
				municipio(MunicipioUtils.createFakeEntity()).
				unidadeFederativa(UnidadeFederativaUtils.createFakeEntity()).
				build();
	}
	
}
