package com.digitalinnovationone.comunidadeapi.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinnovationone.comunidadeapi.dto.request.MembroDTO;
import com.digitalinnovationone.comunidadeapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.comunidadeapi.entity.Membro;
import com.digitalinnovationone.comunidadeapi.exception.MembroNotFoundException;
import com.digitalinnovationone.comunidadeapi.mapper.MembroMapper;
import com.digitalinnovationone.comunidadeapi.repository.MembroRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MembroServiceImpl implements MembroService {

	private MembroRepository membroRepository;
	
	private MembroMapper membroMapper = MembroMapper.INSTANCE;
	
	public MessageResponseDTO criarMembro(MembroDTO membroDTO) {
		Membro membroParaSalvar = membroMapper.toModel(membroDTO);
		Membro salvarMembro = membroRepository.save(membroParaSalvar);
		return criarMessageResponse(salvarMembro, "Membro Criado com ID: ");
	}
	
	public MessageResponseDTO atualizarMembro(Long id, @Valid MembroDTO membroDTO) throws MembroNotFoundException {
		verifyIfExists(id);
		Membro membroParaAtualizar = membroMapper.toModel(membroDTO);
		Membro atualizarMembro = membroRepository.save(membroParaAtualizar);
		return criarMessageResponse(atualizarMembro, "Membro atualizado com ID: ");
	}

	private MessageResponseDTO criarMessageResponse(Membro salvarMembro, String mensagem) {
		return MessageResponseDTO.builder().message(mensagem + salvarMembro.getId()).build();
	}

	public List<MembroDTO> findAll() {
		List<Membro> todosMembros = membroRepository.findAll();
		return todosMembros.stream().map(membroMapper::toDTO).collect(Collectors.toList());
	}

	public MembroDTO findById(Long id) throws MembroNotFoundException {
		Membro membro = verifyIfExists(id);
		return membroMapper.toDTO(membro);
	}

	public void deleteById(Long id) throws MembroNotFoundException {
		verifyIfExists(id);
		membroRepository.deleteById(id);
	}

	private Membro verifyIfExists(Long id) throws MembroNotFoundException {
		return membroRepository.findById(id).orElseThrow(() -> new MembroNotFoundException(id));
	}
	
}
