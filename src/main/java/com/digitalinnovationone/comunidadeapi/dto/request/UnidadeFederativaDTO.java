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
public class UnidadeFederativaDTO {

	private Long id;
	
	@NotEmpty
	@Size(max = 100)
	private String nome;
	
	@NotEmpty
	@Size(max = 2)
	private String sigla;
	
}
