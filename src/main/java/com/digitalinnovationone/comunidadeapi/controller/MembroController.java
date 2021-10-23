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

import com.digitalinnovationone.comunidadeapi.dto.request.MembroDTO;
import com.digitalinnovationone.comunidadeapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.comunidadeapi.exception.MembroNotFoundException;
import com.digitalinnovationone.comunidadeapi.service.MembroService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/membro")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MembroController {

	private MembroService membroService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public MessageResponseDTO criarMembro(@RequestBody @Valid MembroDTO membroDTO) {
		return membroService.criarMembro(membroDTO);
	}
	
	@PutMapping
	public MessageResponseDTO atualizarMembro(@PathVariable Long id, @RequestBody @Valid MembroDTO membroDTO) throws MembroNotFoundException {
		return membroService.atualizarMembro(id, membroDTO);
	}
	
	@GetMapping
	public List<MembroDTO> listar() {
		return membroService.findAll();
	}
	
	@GetMapping("/{id}")
	public MembroDTO findById(@PathVariable Long id) throws MembroNotFoundException{
		return membroService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws MembroNotFoundException{
		membroService.deleteById(id);
	}
	
}
