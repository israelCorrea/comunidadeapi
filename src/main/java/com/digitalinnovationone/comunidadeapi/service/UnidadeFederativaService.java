package com.digitalinnovationone.comunidadeapi.service;

import java.util.List;

import javax.validation.Valid;

import com.digitalinnovationone.comunidadeapi.dto.request.UnidadeFederativaDTO;
import com.digitalinnovationone.comunidadeapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.comunidadeapi.exception.UnidadeFederativaNotFoundException;

public interface UnidadeFederativaService {
	
	public MessageResponseDTO criarUnidadeFederativa(UnidadeFederativaDTO unidadeFederativaDTO);
	
	public MessageResponseDTO atualizarUnidadeFederativa(Long id, @Valid UnidadeFederativaDTO unidadeFederativaDTO) throws UnidadeFederativaNotFoundException;

	public List<UnidadeFederativaDTO> findAll();

	public UnidadeFederativaDTO findById(Long id) throws UnidadeFederativaNotFoundException;

	public void deleteById(Long id) throws UnidadeFederativaNotFoundException;
	
}
