package com.digitalinnovationone.comunidadeapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinnovationone.comunidadeapi.dto.request.MunicipioDTO;
import com.digitalinnovationone.comunidadeapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.comunidadeapi.exception.MunicipioNotFoundException;
import com.digitalinnovationone.comunidadeapi.service.MunicipioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/municipio")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MunicipioController {

	private MunicipioService municipioService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public MessageResponseDTO criarMunicipio(@RequestBody @Valid MunicipioDTO municipioDTO) {
		return municipioService.criarMunicipio(municipioDTO);
	}
	
	@PutMapping
	public MessageResponseDTO atualizarMunicipio(@PathVariable Long id, @RequestBody @Valid MunicipioDTO municipioDTO) throws MunicipioNotFoundException {
		return municipioService.atualizarMunicipio(id, municipioDTO);
	}
	
	@GetMapping
	public List<MunicipioDTO> listar() {
		return municipioService.findAll();
	}
	
	@GetMapping("/{id}")
	public MunicipioDTO findById(@PathVariable Long id) throws MunicipioNotFoundException{
		return municipioService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws MunicipioNotFoundException{
		municipioService.deleteById(id);
	}
	
}
