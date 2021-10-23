package com.digitalinnovationone.comunidadeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalinnovationone.comunidadeapi.entity.Membro;

public interface MembroRepository extends JpaRepository<Membro, Long> {

}
