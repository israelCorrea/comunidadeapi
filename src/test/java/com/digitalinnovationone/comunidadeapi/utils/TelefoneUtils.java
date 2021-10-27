package com.digitalinnovationone.comunidadeapi.utils;

import com.digitalinnovationone.comunidadeapi.dto.request.TelefoneDTO;
import com.digitalinnovationone.comunidadeapi.entity.Telefone;
import com.digitalinnovationone.comunidadeapi.enuns.TipoTelefone;

public class TelefoneUtils {

	private static final Long TELEFONE_ID = 1L;
	private static final String NUMERO_TELEFONE = "(31)99685-4578";
	
	public static TelefoneDTO createFakeDTO() {
		return TelefoneDTO.builder().
				numeroTelefone(NUMERO_TELEFONE).
				tipoTelefone(TipoTelefone.CELULAR).build();
	}
	
	public static Telefone createFakeEntity() {
		return Telefone.builder().
				id(TELEFONE_ID).
				numeroTelefone(NUMERO_TELEFONE).
				tipoTelefone(TipoTelefone.CELULAR).build();
	}
	
}
