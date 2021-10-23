package com.digitalinnovationone.comunidadeapi.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.digitalinnovationone.comunidadeapi.enuns.TipoLogradouro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

	@Enumerated(EnumType.ORDINAL)
	private TipoLogradouro tipoLogradouro;
	
	@NotEmpty
	@Size(max = 255)
	private String logradouro;
	
	@NotEmpty
	@Size(max = 10)
	private String numero;
	
	@Size(max = 60)
	private String complemento;
	
	@NotEmpty
	@Size(max = 100)
	private String bairro;
	
	private UnidadeFederativaDTO unidadeFederativa;
	
	private MunicipioDTO municipio;
	
	@NotEmpty
	@Size(max = 8)
	private String cep;
	
}
