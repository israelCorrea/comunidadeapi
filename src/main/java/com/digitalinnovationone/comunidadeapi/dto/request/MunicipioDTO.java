package com.digitalinnovationone.comunidadeapi.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MunicipioDTO {

	private Long id;
	
	@NotEmpty
	private UnidadeFederativaDTO unidadeFederativa;
	
	@NotEmpty
	@Size(max = 500)
	private String nome;
	
}
