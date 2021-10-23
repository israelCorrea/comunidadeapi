package com.digitalinnovationone.comunidadeapi.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.digitalinnovationone.comunidadeapi.enuns.TipoTelefone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoTelefone tipoTelefone;
	
	@NotEmpty
	@Size(min = 13, max = 14)
	private String numeroTelefone;
	
}
