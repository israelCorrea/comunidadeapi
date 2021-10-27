package com.digitalinnovationone.comunidadeapi.service;

import static com.digitalinnovationone.comunidadeapi.utils.UnidadeFederativaUtils.createFakeDTO;
import static com.digitalinnovationone.comunidadeapi.utils.UnidadeFederativaUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.digitalinnovationone.comunidadeapi.dto.request.UnidadeFederativaDTO;
import com.digitalinnovationone.comunidadeapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.comunidadeapi.entity.UnidadeFederativa;
import com.digitalinnovationone.comunidadeapi.exception.UnidadeFederativaNotFoundException;
import com.digitalinnovationone.comunidadeapi.repository.UnidadeFederativaRepository;

@ExtendWith(MockitoExtension.class)
public class UnidadeFederativaServiceTest {

	@Mock
	private UnidadeFederativaRepository unidadeFederativaRepository;
	
	@InjectMocks
	private UnidadeFederativaServiceImpl unidadeFederativaService;
	
	@Mock
	private ModelMapper modelMapper;
	
	@Test
	public void testGivenUnidadeFederativaDTOThenReturnSavedMessage() {
		UnidadeFederativaDTO unidadeFederativaDTO = createFakeDTO();
		UnidadeFederativa expectedSavedUnidadeFederativa = createFakeEntity();
		
		when(unidadeFederativaService.toEntity(unidadeFederativaDTO)).thenReturn(expectedSavedUnidadeFederativa);
		when(unidadeFederativaRepository.save(Mockito.any(UnidadeFederativa.class))).thenReturn(expectedSavedUnidadeFederativa);
		
		MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedUnidadeFederativa.getId());
		MessageResponseDTO successMessage = unidadeFederativaService.criarUnidadeFederativa(unidadeFederativaDTO);
		
		assertEquals(expectedSuccessMessage, successMessage);
	}

	@Test
    void testGivenValidUnidadeFederativaIdThenReturnThisUnidadeFederativa() throws UnidadeFederativaNotFoundException {
        UnidadeFederativaDTO expectedUnidadeFederativaDTO = createFakeDTO();
        UnidadeFederativa expectedSavedUnidadeFederativa = createFakeEntity();
        expectedUnidadeFederativaDTO.setId(expectedSavedUnidadeFederativa.getId());

        when(unidadeFederativaRepository.findById(expectedSavedUnidadeFederativa.getId())).thenReturn(Optional.of(expectedSavedUnidadeFederativa));
        when(unidadeFederativaService.toDTO(expectedSavedUnidadeFederativa)).thenReturn(expectedUnidadeFederativaDTO);

        UnidadeFederativaDTO unidadeFederativaDTO = unidadeFederativaService.findById(expectedSavedUnidadeFederativa.getId());

        assertEquals(expectedUnidadeFederativaDTO, unidadeFederativaDTO);

        assertEquals(expectedSavedUnidadeFederativa.getId(), unidadeFederativaDTO.getId());
        assertEquals(expectedSavedUnidadeFederativa.getNome(), unidadeFederativaDTO.getNome());
    }

    @Test
    void testGivenInvalidUnidadeFederativaIdThenThrowException() {
        var invalidUnidadeFederativaId = 1L;
        when(unidadeFederativaRepository.findById(invalidUnidadeFederativaId))
                .thenReturn(Optional.ofNullable(Mockito.any(UnidadeFederativa.class)));

        assertThrows(UnidadeFederativaNotFoundException.class, () -> unidadeFederativaService.findById(invalidUnidadeFederativaId));
    }

    @Test
    void testGivenNoDataThenReturnAllPeopleRegistered() {
        List<UnidadeFederativa> expectedRegisteredPeople = Collections.singletonList(createFakeEntity());
        UnidadeFederativaDTO unidadeFederativaDTO = createFakeDTO();

        when(unidadeFederativaRepository.findAll()).thenReturn(expectedRegisteredPeople);
        //when(unidadeFederativaService.toDTO(Mockito.any(UnidadeFederativa.class))).thenReturn(unidadeFederativaDTO);

        List<UnidadeFederativaDTO> expectedPeopleDTOList = unidadeFederativaService.findAll();

        assertFalse(expectedPeopleDTOList.isEmpty());
        //assertEquals(expectedPeopleDTOList.get(0).getId(), unidadeFederativaDTO.getId());
    }

    @Test
    void testGivenValidUnidadeFederativaIdAndUpdateInfoThenReturnSuccesOnUpdate() throws UnidadeFederativaNotFoundException {
        var updatedUnidadeFederativaId = 2L;

        UnidadeFederativaDTO updateUnidadeFederativaDTORequest = createFakeDTO();
        updateUnidadeFederativaDTORequest.setId(updatedUnidadeFederativaId);
        updateUnidadeFederativaDTORequest.setNome("Last name updated");

        UnidadeFederativa expectedUnidadeFederativaToUpdate = createFakeEntity();
        expectedUnidadeFederativaToUpdate.setId(updatedUnidadeFederativaId);

        UnidadeFederativa expectedUnidadeFederativaUpdated = createFakeEntity();
        expectedUnidadeFederativaUpdated.setId(updatedUnidadeFederativaId);
        expectedUnidadeFederativaToUpdate.setNome(updateUnidadeFederativaDTORequest.getNome());

        when(unidadeFederativaRepository.findById(updatedUnidadeFederativaId)).thenReturn(Optional.of(expectedUnidadeFederativaUpdated));
        when(unidadeFederativaService.toEntity(updateUnidadeFederativaDTORequest)).thenReturn(expectedUnidadeFederativaUpdated);
        when(unidadeFederativaRepository.save(any(UnidadeFederativa.class))).thenReturn(expectedUnidadeFederativaUpdated);

        MessageResponseDTO successMessage = unidadeFederativaService.atualizarUnidadeFederativa(updatedUnidadeFederativaId, updateUnidadeFederativaDTORequest);

        assertEquals("Unidade Federativa atualizada com ID: 2", successMessage.getMessage());
    }

    @Test
    void testGivenInvalidUnidadeFederativaIdAndUpdateInfoThenThrowExceptionOnUpdate() throws UnidadeFederativaNotFoundException {
        var invalidUnidadeFederativaId = 1L;

        UnidadeFederativaDTO updateUnidadeFederativaDTORequest = createFakeDTO();
        updateUnidadeFederativaDTORequest.setId(invalidUnidadeFederativaId);
        updateUnidadeFederativaDTORequest.setNome("Nome atualizado");

        when(unidadeFederativaRepository.findById(invalidUnidadeFederativaId))
                .thenReturn(Optional.ofNullable(any(UnidadeFederativa.class)));

        assertThrows(UnidadeFederativaNotFoundException.class, () -> unidadeFederativaService.atualizarUnidadeFederativa(invalidUnidadeFederativaId, updateUnidadeFederativaDTORequest));
    }

    @Test
    void testGivenValidUnidadeFederativaIdThenReturnSuccesOnDelete() throws UnidadeFederativaNotFoundException {
        var deletedUnidadeFederativaId = 1L;
        UnidadeFederativa expectedUnidadeFederativaToDelete = createFakeEntity();

        when(unidadeFederativaRepository.findById(deletedUnidadeFederativaId)).thenReturn(Optional.of(expectedUnidadeFederativaToDelete));
        unidadeFederativaService.deleteById(deletedUnidadeFederativaId);

        verify(unidadeFederativaRepository, times(1)).deleteById(deletedUnidadeFederativaId);
    }

    @Test
    void testGivenInvalidUnidadeFederativaIdThenReturnSuccesOnDelete() throws UnidadeFederativaNotFoundException {
        var invalidUnidadeFederativaId = 1L;
        
        when(unidadeFederativaRepository.findById(invalidUnidadeFederativaId))
                .thenReturn(Optional.ofNullable(any(UnidadeFederativa.class)));

        assertThrows(UnidadeFederativaNotFoundException.class, () -> unidadeFederativaService.deleteById(invalidUnidadeFederativaId));
    }
	
	private MessageResponseDTO createExpectedMessageResponse(Long id) {
		return MessageResponseDTO.builder().message("Unidade Federativa criada com ID: " + id).build();
	}
}
