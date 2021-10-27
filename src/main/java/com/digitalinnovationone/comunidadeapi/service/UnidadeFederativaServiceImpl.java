package com.digitalinnovationone.comunidadeapi.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinnovationone.comunidadeapi.dto.request.UnidadeFederativaDTO;
import com.digitalinnovationone.comunidadeapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.comunidadeapi.entity.UnidadeFederativa;
import com.digitalinnovationone.comunidadeapi.exception.UnidadeFederativaNotFoundException;
import com.digitalinnovationone.comunidadeapi.repository.UnidadeFederativaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UnidadeFederativaServiceImpl implements UnidadeFederativaService {

	private UnidadeFederativaRepository unidadeFederativaRepository;
	
	private ModelMapper modelMapper;
	
	public MessageResponseDTO criarUnidadeFederativa(UnidadeFederativaDTO unidadeFederativaDTO) {
		UnidadeFederativa unidadeFederativaParaSalvar = toEntity(unidadeFederativaDTO);
		UnidadeFederativa salvarUnidadeFederativa = unidadeFederativaRepository.save(unidadeFederativaParaSalvar);
		return criarMessageResponse(salvarUnidadeFederativa, "Unidade Federativa criada com ID: ");
	}
	
	public MessageResponseDTO atualizarUnidadeFederativa(Long id, @Valid UnidadeFederativaDTO unidadeFederativaDTO) throws UnidadeFederativaNotFoundException {
		verifyIfExists(id);
		UnidadeFederativa unidadeFederativaParaAtualizar = toEntity(unidadeFederativaDTO);
		UnidadeFederativa atualizarUnidadeFederativa = unidadeFederativaRepository.save(unidadeFederativaParaAtualizar);
		return criarMessageResponse(atualizarUnidadeFederativa, "Unidade Federativa atualizada com ID: ");
	}

	private MessageResponseDTO criarMessageResponse(UnidadeFederativa salvarUnidadeFederativa, String mensagem) {
		return MessageResponseDTO.builder().message(mensagem + salvarUnidadeFederativa.getId()).build();
	}

	public List<UnidadeFederativaDTO> findAll() {
		List<UnidadeFederativa> todasUnidadeFederativas = unidadeFederativaRepository.findAll();
		return todasUnidadeFederativas.stream().map(this::toDTO).collect(Collectors.toList());
	}

	public UnidadeFederativaDTO findById(Long id) throws UnidadeFederativaNotFoundException {
		UnidadeFederativa unidadeFederativa = verifyIfExists(id);
		return toDTO(unidadeFederativa);
	}

	public void deleteById(Long id) throws UnidadeFederativaNotFoundException {
		verifyIfExists(id);
		unidadeFederativaRepository.deleteById(id);
	}
	
	public UnidadeFederativa toEntity(UnidadeFederativaDTO unidadeFederativaDTO) {
		return modelMapper.map(unidadeFederativaDTO, UnidadeFederativa.class);
	}
	
	public UnidadeFederativaDTO toDTO(UnidadeFederativa unidadeFederativa) {
		return modelMapper.map(unidadeFederativa, UnidadeFederativaDTO.class);
	}
	
	private UnidadeFederativa verifyIfExists(Long id) throws UnidadeFederativaNotFoundException {
		return unidadeFederativaRepository.findById(id).orElseThrow(() -> new UnidadeFederativaNotFoundException(id));
	}
}
