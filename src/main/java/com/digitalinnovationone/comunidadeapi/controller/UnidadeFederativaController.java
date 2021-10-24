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

import com.digitalinnovationone.comunidadeapi.dto.request.UnidadeFederativaDTO;
import com.digitalinnovationone.comunidadeapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.comunidadeapi.exception.UnidadeFederativaNotFoundException;
import com.digitalinnovationone.comunidadeapi.service.UnidadeFederativaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/unidade-federativa")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UnidadeFederativaController {

	private UnidadeFederativaService unidadeFederativaService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public MessageResponseDTO criarUnidadeFederativa(@RequestBody @Valid UnidadeFederativaDTO unidadeFederativaDTO) {
		return unidadeFederativaService.criarUnidadeFederativa(unidadeFederativaDTO);
	}
	
	@PutMapping
	public MessageResponseDTO atualizarUnidadeFederativa(@PathVariable Long id, @RequestBody @Valid UnidadeFederativaDTO unidadeFederativaDTO) throws UnidadeFederativaNotFoundException {
		return unidadeFederativaService.atualizarUnidadeFederativa(id, unidadeFederativaDTO);
	}
	
	@GetMapping
	public List<UnidadeFederativaDTO> listar() {
		return unidadeFederativaService.findAll();
	}
	
	@GetMapping("/{id}")
	public UnidadeFederativaDTO findById(@PathVariable Long id) throws UnidadeFederativaNotFoundException{
		return unidadeFederativaService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws UnidadeFederativaNotFoundException{
		unidadeFederativaService.deleteById(id);
	}
	
}
