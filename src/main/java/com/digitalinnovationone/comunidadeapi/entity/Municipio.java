package com.digitalinnovationone.comunidadeapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.digitalinnovationone.comunidadeapi.validation.ValidationGroups;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(groups = ValidationGroups.MunicipioId.class)
	private Long id;
	
	@Valid
	@NotNull
	@ConvertGroup(from = Default.class, to = ValidationGroups.UnidadeFederativaId.class)
	@JoinColumn(name = "unidade_federativa_id")
	@ManyToOne
	private UnidadeFederativa unidadeFederativa;
	
	@NotBlank
	@Size(max = 500)
	@Column
	private String nome;
	
}
