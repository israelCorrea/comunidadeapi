package com.digitalinnovationone.comunidadeapi.service;

import java.util.List;

import javax.validation.Valid;

import com.digitalinnovationone.comunidadeapi.dto.request.MunicipioDTO;
import com.digitalinnovationone.comunidadeapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.comunidadeapi.exception.MunicipioNotFoundException;

public interface MunicipioService {
	
	public MessageResponseDTO criarMunicipio(MunicipioDTO municipioDTO);
	
	public MessageResponseDTO atualizarMunicipio(Long id, @Valid MunicipioDTO municipioDTO) throws MunicipioNotFoundException;

	public List<MunicipioDTO> findAll();

	public MunicipioDTO findById(Long id) throws MunicipioNotFoundException;

	public void deleteById(Long id) throws MunicipioNotFoundException;
	
}
