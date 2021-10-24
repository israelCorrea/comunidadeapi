package com.digitalinnovationone.comunidadeapi.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinnovationone.comunidadeapi.dto.request.MunicipioDTO;
import com.digitalinnovationone.comunidadeapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.comunidadeapi.entity.Municipio;
import com.digitalinnovationone.comunidadeapi.exception.MunicipioNotFoundException;
import com.digitalinnovationone.comunidadeapi.repository.MunicipioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MunicipioServiceImpl implements MunicipioService {

	private MunicipioRepository municipioRepository;
	
	private ModelMapper modelMapper;
	
	public MessageResponseDTO criarMunicipio(MunicipioDTO municipioDTO) {
		Municipio municipioParaSalvar = toEntity(municipioDTO);
		Municipio salvarMunicipio = municipioRepository.save(municipioParaSalvar);
		return criarMessageResponse(salvarMunicipio, "Municipio criado com ID: ");
	}
	
	public MessageResponseDTO atualizarMunicipio(Long id, @Valid MunicipioDTO municipioDTO) throws MunicipioNotFoundException {
		verifyIfExists(id);
		Municipio municipioParaAtualizar = toEntity(municipioDTO);
		Municipio atualizarMunicipio = municipioRepository.save(municipioParaAtualizar);
		return criarMessageResponse(atualizarMunicipio, "Municipio atualizado com ID: ");
	}

	private MessageResponseDTO criarMessageResponse(Municipio salvarMunicipio, String mensagem) {
		return MessageResponseDTO.builder().message(mensagem + salvarMunicipio.getId()).build();
	}

	public List<MunicipioDTO> findAll() {
		List<Municipio> todosMunicipios = municipioRepository.findAll();
		return todosMunicipios.stream().map(this::toDTO).collect(Collectors.toList());
	}

	public MunicipioDTO findById(Long id) throws MunicipioNotFoundException {
		Municipio municipio = verifyIfExists(id);
		return toDTO(municipio);
	}

	public void deleteById(Long id) throws MunicipioNotFoundException {
		verifyIfExists(id);
		municipioRepository.deleteById(id);
	}

	private Municipio verifyIfExists(Long id) throws MunicipioNotFoundException {
		return municipioRepository.findById(id).orElseThrow(() -> new MunicipioNotFoundException(id));
	}
	
	private Municipio toEntity(MunicipioDTO municipioDTO) {
		return modelMapper.map(municipioDTO, Municipio.class);
	}
	
	private MunicipioDTO toDTO(Municipio municipio) {
		return modelMapper.map(municipio, MunicipioDTO.class);
	}
	
}
