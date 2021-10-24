package com.digitalinnovationone.comunidadeapi.dto.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeFederativaIdDTO {

	@NotNull
	private Long id;
	
}
