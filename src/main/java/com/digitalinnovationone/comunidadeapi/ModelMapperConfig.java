package com.digitalinnovationone.comunidadeapi;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper moodelMapper() {
		return new ModelMapper();
	}
	
}
