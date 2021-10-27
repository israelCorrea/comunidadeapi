package com.digitalinnovationone.comunidadeapi.utils;

import java.util.Collections;

import com.digitalinnovationone.comunidadeapi.dto.request.MembroDTO;
import com.digitalinnovationone.comunidadeapi.entity.Membro;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MembroUtils {

	private static final Long PERSON_ID = 1L;
	private static final String FIRST_NAME = "João";
	private static final String LAST_NAME = "Silva";
	private static final String CPF_NUMBER = "123.456.789-11";
	
	public static MembroDTO createFakeDTO() {
		return MembroDTO.builder().
				nome(FIRST_NAME).
				sobrenome(LAST_NAME).
				cpf(CPF_NUMBER).
				telefones(Collections.singletonList(TelefoneUtils.createFakeDTO())).
				build();
	}
	
	public static Membro createFakeEntity() {
		return Membro.builder().
				id(PERSON_ID).
				nome(FIRST_NAME).
				sobrenome(LAST_NAME).
				cpf(CPF_NUMBER).
				telefones(Collections.singletonList(TelefoneUtils.createFakeEntity())).
				build();
	}
	
	public static String asJsonString(MembroDTO personDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(personDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
}
