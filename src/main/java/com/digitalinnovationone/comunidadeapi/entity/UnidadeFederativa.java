package com.digitalinnovationone.comunidadeapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class UnidadeFederativa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(groups = ValidationGroups.UnidadeFederativaId.class)
	private Long id;
	
	@NotBlank
	@Size(max = 100)
	@Column
	private String nome;
	
	@NotBlank
	@Size(max = 2)
	@Column
	private String sigla;
	
}
