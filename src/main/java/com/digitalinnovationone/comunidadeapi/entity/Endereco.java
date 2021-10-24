package com.digitalinnovationone.comunidadeapi.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.digitalinnovationone.comunidadeapi.enuns.TipoLogradouro;
import com.digitalinnovationone.comunidadeapi.validation.ValidationGroups;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	@Enumerated(EnumType.ORDINAL)
	private TipoLogradouro tipoLogradouro;
	
	@Size(max = 255)
	@Column(nullable = false)
	private String logradouro;
	
	@Size(max = 10)
	@Column(nullable = false)
	private String numero;
	
	@Size(max = 60)
	@Column(nullable = true)
	private String complemento;
	
	@Size(max = 100)
	@Column(nullable = false)
	private String bairro;
	
	@ConvertGroup(from = Default.class, to = ValidationGroups.UnidadeFederativaId.class)
	@ManyToOne
	@JoinColumn(name = "unidade_federativa_id", nullable = false)
	private UnidadeFederativa unidadeFederativa;
	
	@ConvertGroup(from = Default.class, to = ValidationGroups.MunicipioId.class)
	@ManyToOne
	@JoinColumn(name = "municipio_id", nullable = false)
	private Municipio municipio;
	
	@Size(max = 8)
	@Column(nullable = false)
	private String cep;
	
}
