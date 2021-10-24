package com.digitalinnovationone.comunidadeapi.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinnovationone.comunidadeapi.dto.request.MembroDTO;
import com.digitalinnovationone.comunidadeapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.comunidadeapi.entity.Membro;
import com.digitalinnovationone.comunidadeapi.exception.MembroNotFoundException;
import com.digitalinnovationone.comunidadeapi.repository.MembroRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MembroServiceImpl implements MembroService {

	private MembroRepository membroRepository;
	
	private ModelMapper modelMapper;
	
	public MessageResponseDTO criarMembro(MembroDTO membroDTO) {
		Membro membroParaSalvar = toEntity(membroDTO);
		Membro salvarMembro = membroRepository.save(membroParaSalvar);
		return criarMessageResponse(salvarMembro, "Membro criado com ID: ");
	}
	
	public MessageResponseDTO atualizarMembro(Long id, @Valid MembroDTO membroDTO) throws MembroNotFoundException {
		verifyIfExists(id);
		Membro membroParaAtualizar = toEntity(membroDTO);
		Membro atualizarMembro = membroRepository.save(membroParaAtualizar);
		return criarMessageResponse(atualizarMembro, "Membro atualizado com ID: ");
	}

	private MessageResponseDTO criarMessageResponse(Membro salvarMembro, String mensagem) {
		return MessageResponseDTO.builder().message(mensagem + salvarMembro.getId()).build();
	}

	public List<MembroDTO> findAll() {
		List<Membro> todosMembros = membroRepository.findAll();
		return todosMembros.stream().map(this::toDTO).collect(Collectors.toList());
	}

	public MembroDTO findById(Long id) throws MembroNotFoundException {
		Membro membro = verifyIfExists(id);
		return toDTO(membro);
	}

	public void deleteById(Long id) throws MembroNotFoundException {
		verifyIfExists(id);
		membroRepository.deleteById(id);
	}

	private Membro verifyIfExists(Long id) throws MembroNotFoundException {
		return membroRepository.findById(id).orElseThrow(() -> new MembroNotFoundException(id));
	}
	
	private Membro toEntity(MembroDTO membroDTO) {
		return modelMapper.map(membroDTO, Membro.class);
	}
	
	private MembroDTO toDTO(Membro membro) {
		return modelMapper.map(membro, MembroDTO.class);
	}
}
