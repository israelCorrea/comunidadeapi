package com.digitalinnovationone.comunidadeapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.digitalinnovationone.comunidadeapi.dto.request.MembroDTO;
import com.digitalinnovationone.comunidadeapi.entity.Membro;

@Mapper(componentModel = "spring")
public interface MembroMapper {

	MembroMapper INSTANCE = Mappers.getMapper(MembroMapper.class);
	
	@Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd-MM-yyyy")
	Membro toModel(MembroDTO membroDTO);
	
	MembroDTO toDTO(Membro membro);
	
}
