package com.digitalinnovationone.comunidadeapi.service;

import java.util.List;

import javax.validation.Valid;

import com.digitalinnovationone.comunidadeapi.dto.request.MembroDTO;
import com.digitalinnovationone.comunidadeapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.comunidadeapi.exception.MembroNotFoundException;

public interface MembroService {
	
	public MessageResponseDTO criarMembro(MembroDTO membroDTO);
	
	public MessageResponseDTO atualizarMembro(Long id, @Valid MembroDTO membroDTO) throws MembroNotFoundException;

	public List<MembroDTO> findAll();

	public MembroDTO findById(Long id) throws MembroNotFoundException;

	public void deleteById(Long id) throws MembroNotFoundException;
	
}
