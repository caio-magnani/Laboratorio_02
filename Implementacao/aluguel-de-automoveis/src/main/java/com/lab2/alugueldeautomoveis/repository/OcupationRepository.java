package com.lab2.alugueldeautomoveis.repository;

import com.lab2.alugueldeautomoveis.model.Ocupation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OcupationRepository extends JpaRepository<Ocupation, Long> {
    
}
